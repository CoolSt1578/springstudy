package com.study.aop.aop3;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @AspectJ注解驱动的切面
 * Created by guodd on 2018/1/29.
 */
public class Main {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("aop3.xml");
        Sleepable me = (Sleepable) context.getBean("me");
        me.sleep();
    }
}
