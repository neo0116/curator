package com.zookeeper.curator.com.zookeeper.curator;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;

public class WatcherDemo {

    public static final String host = "122.51.167.43:2181";
    public static final String path = "/watcher";

    public static void main(String[] args) {
        ZooKeeper zooKeeper = null;
        try {
            zooKeeper = new ZooKeeper(host, 5000, new Watcher() {
                @Override
                public void process(WatchedEvent event) {
                    System.out.println(event.getType());
                }
            });
            zooKeeper.create(path, "q".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);

            //节点监听+节点变化
            zooKeeper.exists(path, true);
//            zooKeeper.getData(path, true, null);
            zooKeeper.setData(path, "a".getBytes(), -1);

            //子节点监听+节点变化
            zooKeeper.getChildren(path, true);
            zooKeeper.create(path + "/subNode", "q".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
