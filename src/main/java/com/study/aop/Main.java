package com.study.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by guodd on 2018/1/29.
 */
public class Main {

    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("aop1.xml");
        HelloWorld hw1 = (HelloWorld) ctx.getBean("helloWorld1");
        HelloWorld hw2 = (HelloWorld) ctx.getBean("helloWorld2");

        hw1.printHelloWorld();
        System.out.println();
        hw1.doPrint();

        System.out.println();
        hw2.printHelloWorld();
        System.out.println();
        hw2.doPrint();
    }
}
