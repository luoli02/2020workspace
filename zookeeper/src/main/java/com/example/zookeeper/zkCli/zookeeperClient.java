package com.example.zookeeper.zkCli;

import org.I0Itec.zkclient.ContentWatcher;
import org.I0Itec.zkclient.IZkChildListener;
import org.I0Itec.zkclient.IZkDataListener;
import org.I0Itec.zkclient.ZkClient;
import org.I0Itec.zkclient.exception.ZkMarshallingError;
import org.I0Itec.zkclient.serialize.BytesPushThroughSerializer;
import org.I0Itec.zkclient.serialize.SerializableSerializer;
import org.I0Itec.zkclient.serialize.ZkSerializer;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

public class zookeeperClient {

    /**
     * 实现节点的更新失败
     * 节点创建删除都要输出所有节点的data
     * 节点的数据修改也要输出所有节点的data
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        ZkClient zkClient = new ZkClient(
                "120.24.172.236:2181", 5000, 5000);
        zkClient.setZkSerializer(new MyZkSerializer());
        List<String> children = zkClient.getChildren("/name");
        children.forEach(x -> {
            String o = zkClient.readData("/name/" + x);
            System.out.println(o);

        });

        Thread.sleep(Long.MAX_VALUE);
    }
}

//自定义zkClient的序列化
class MyZkSerializer implements ZkSerializer {
    public Object deserialize(byte[] bytes) throws ZkMarshallingError {
        return new String(bytes, Charset.forName("UTF-8"));
    }

    public byte[] serialize(Object obj) throws ZkMarshallingError {
        return String.valueOf(obj).getBytes(Charset.forName("UTF-8"));
    }
}

