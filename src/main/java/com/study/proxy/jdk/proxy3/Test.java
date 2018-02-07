package com.study.proxy.jdk.proxy3;

import java.lang.reflect.Proxy;

/**
 * Created by guodd on 2018/2/2.
 */
public class Test {

    public static void main(String[] args) {
        HelloService service = new HelloServiceImpl();
        HelloServiceProxy proxy = new HelloServiceProxy(service);
        service = (HelloService) Proxy.newProxyInstance(service.getClass().getClassLoader(), service.getClass().getInterfaces(), proxy);
        service.sayHello("张三");
    }
}
