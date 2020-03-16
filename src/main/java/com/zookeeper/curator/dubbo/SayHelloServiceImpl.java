package com.zookeeper.curator.dubbo;

import org.apache.dubbo.config.annotation.Service;

@Service //JDKCompiler、
public class SayHelloServiceImpl implements ISayHelloService {

    @Override
    public String sayHello(String content) {
        return "Hello :"+content;
    }
}
