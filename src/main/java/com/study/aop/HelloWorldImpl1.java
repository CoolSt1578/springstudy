package com.study.aop;

import org.springframework.stereotype.Service;

/**
 * Created by guodd on 2018/1/29.
 */
@Service("helloWorld1")
public class HelloWorldImpl1 implements HelloWorld {

    public void printHelloWorld() {
        System.out.println("HelloWorldImpl1 printHello");
    }

    public void doPrint() {
        System.out.println("HelloWorldImpl1 doPrint");
    }

}
