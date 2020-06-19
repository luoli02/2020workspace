package com.example.zookeeper.zklock;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.locks.InterProcessMutex;
import org.apache.curator.retry.ExponentialBackoffRetry;

public class DisLockDemo {
    public static void main(String[] args) {

        /**
         * 所有线程第一步都会去不停的尝试获取锁
         * 然后获取成功后必须要释放锁，第二个线程才能继续的获取锁
         */
        CuratorFramework curatorFramework = CuratorFrameworkFactory.
                newClient("120.24.172.236:2181", 5000, 4000,
                        new ExponentialBackoffRetry(1000, 3));
        //建立客户端连接
        curatorFramework.start();
        // 已”/locks“为主节点 ，然后线程会在这个节点下面创建临时有序的节点
        InterProcessMutex lock = new InterProcessMutex(curatorFramework, "/locks");
        for (int i = 0; i < 20; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + "->尝试获取锁");

                try {
                    //抢占锁的操作
                    lock.acquire();
                    System.out.println(Thread.currentThread().getName() + "->获取锁成功");
                } catch (Exception e) {
                    e.printStackTrace();
                }
                try {
                    Thread.sleep(2000);
                    //当前获得锁的线程在两秒后释放
                    lock.release();
                    System.out.println(Thread.currentThread().getName() + "->当前线程释放锁成功");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }, "T" + i).start();
        }


    }


}
