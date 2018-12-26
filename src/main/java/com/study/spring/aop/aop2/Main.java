package com.study.spring.aop.aop2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 经典的基于代理的AOP
 * Created by guodd on 2018/1/29.
 */
public class Main {
    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("aop2.xml");
        Sleepable me = (Sleepable) context.getBean("me");
        me.sleep();
    }
}
