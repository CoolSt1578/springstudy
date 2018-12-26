package com.study.spring.aop.aop1;

import org.springframework.stereotype.Service;

/**
 * Created by guodd on 2018/1/29.
 */
@Service("helloWorld1")
public class HelloWorldImpl1 implements HelloWorld {

    @Override
    public void printHelloWorld() {
        System.out.println("HelloWorldImpl1 printHello");
    }

    @Override
    public void doPrint() {
        System.out.println("HelloWorldImpl1 doPrint");
    }

}
