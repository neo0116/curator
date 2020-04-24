package com.zookeeper.curator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(value = {"com.zookeeper.curator.dubbo.scan"})
@SpringBootApplication
public class CuratorApplication {

    public static void main(String[] args) {
        SpringApplication.run(CuratorApplication.class, args);
    }

}
