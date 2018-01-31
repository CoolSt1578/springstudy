package com.study.aop;

import org.springframework.stereotype.Service;

/**
 * Created by guodd on 2018/1/29.
 */
@Service("helloWorld2")
public class HelloWorldImpl2 implements HelloWorld {

    public void printHelloWorld() {
        System.out.println("HelloWorldImpl2 printHello");
    }

    public void doPrint() {
        System.out.println("HelloWorldImpl2 doPrint");
    }
}
