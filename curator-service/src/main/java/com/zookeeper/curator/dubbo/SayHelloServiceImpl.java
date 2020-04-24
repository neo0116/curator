package com.zookeeper.curator.dubbo;

import com.zookeeper.curator.dubbo.scan.AA;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service //JDKCompiler、
public class SayHelloServiceImpl implements ISayHelloService {




    @Autowired
    AA aa;

    @Override
    public String sayHello(String content) {
        return "Hello :" + content + aa.get();
    }
}
