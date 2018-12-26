package com.study.spring.aop.aop1;

import org.springframework.stereotype.Service;

/**
 * Created by guodd on 2018/1/29.
 */
@Service("helloWorld2")
public class HelloWorldImpl2 implements HelloWorld {

    @Override
    public void printHelloWorld() {
        System.out.println("HelloWorldImpl2 printHello");
    }

    @Override
    public void doPrint() {
        System.out.println("HelloWorldImpl2 doPrint");
    }
}
