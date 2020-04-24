package com.zookeeper.curator.com.zookeeper.curator;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.locks.InterProcessMutex;
import org.apache.curator.retry.ExponentialBackoffRetry;

public class LockDemo {

    public static final String host = "122.51.167.43:2181";
    public static final String lock = "/locks";

    public static final CuratorFramework curatorFramework = CuratorFrameworkFactory.builder()
            .connectString(host)
            .sessionTimeoutMs(5000)
            .retryPolicy(new ExponentialBackoffRetry(1000, 3))
            .build();

    public static void main(String[] args) {
        LockDemo lockDemo = new LockDemo();
        curatorFramework.start();
        final InterProcessMutex interProcessMutex = new InterProcessMutex(curatorFramework, lock);

        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                try {
                    System.out.println("线程开始抢锁" + Thread.currentThread().getName());
                    interProcessMutex.acquire();
                    System.out.println("线程" + Thread.currentThread().getName() + "抢到");

                    Thread.sleep(4000);

                    interProcessMutex.release();
                    System.out.println("线程" + Thread.currentThread().getName() + "释放锁");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }, "Thread" + i).start();

        }
    }
}
