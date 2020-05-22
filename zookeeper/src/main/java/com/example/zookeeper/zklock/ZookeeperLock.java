package com.example.zookeeper.zklock;

import org.I0Itec.zkclient.IZkDataListener;
import org.I0Itec.zkclient.ZkClient;

import java.util.List;
import java.util.stream.Collectors;

public class ZookeeperLock {
    private String server = "120.24.172.236:2181";
    private ZkClient zkClient;
    private static final String rootPath = "/tuling-lock";

    public ZookeeperLock() {
        zkClient = new ZkClient(server, 5000, 20000);
        buildRoot();
    }

    // 构建根节点
    public void buildRoot() {
        if (!zkClient.exists(rootPath)) {
            zkClient.createPersistent(rootPath);
        }
    }

    public Lock lock(String lockId, long timeout) {
        Lock lockNode = createLockNode(lockId);
        lockNode = tryActiveLock(lockNode);// 尝试激活锁
        if (!lockNode.isActive()) {
            try {
                synchronized (lockNode) {
                    lockNode.wait(timeout);
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        if (!lockNode.isActive()) {
            throw new RuntimeException(" lock  timeout");
        }
        return lockNode;
    }

    public void unlock(Lock lock) {
        if (lock.isActive()) {
            zkClient.delete(lock.getPath());
        }
    }

    // 尝试激活锁
    private Lock tryActiveLock(Lock lockNode) {
        // 判断当前是否为最小节点
        List<String> list = zkClient.getChildren(rootPath)
                .stream()
                .sorted()
                .map(p -> rootPath + "/" + p)
                .collect(Collectors.toList());
        String firstNodePath = list.get(0);
        if (firstNodePath.equals(lockNode.getPath())) {
            lockNode.setActive(true);
        } else {
            String upNodePath = list.get(list.indexOf(lockNode.getPath()) - 1);
            zkClient.subscribeDataChanges(upNodePath, new IZkDataListener() {
                @Override
                public void handleDataChange(String dataPath, Object data) throws Exception {

                }

                @Override
                public void handleDataDeleted(String dataPath) throws Exception {
                    // 事件处理 与心跳 在同一个线程，如果Debug时占用太多时间，将导致本节点被删除，从而影响锁逻辑。
                    System.out.println("节点删除:" + dataPath);
                    Lock lock = tryActiveLock(lockNode);
                    synchronized (lockNode) {
                        if (lock.isActive()) {
                            lockNode.notify();
                        }
                    }
                    zkClient.unsubscribeDataChanges(upNodePath, this);
                }
            });
        }
        return lockNode;
    }


    public Lock createLockNode(String lockId) {
        String nodePath = zkClient.createEphemeralSequential(rootPath + "/" + lockId, "lock");
        return new Lock(lockId, nodePath);
    }

}
