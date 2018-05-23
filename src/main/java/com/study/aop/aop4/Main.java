package com.study.aop.aop4;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**使用Spring来定义纯粹的POJO切面（名字很绕口，其实就是纯粹通过<aop1:config>标签配置，也是一种比较简单的方式
 * Created by guodd on 2018/1/29.
 */
public class Main {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("aop4.xml");
        Sleepable me = (Sleepable) context.getBean("me");
        me.sleep();
    }
}
