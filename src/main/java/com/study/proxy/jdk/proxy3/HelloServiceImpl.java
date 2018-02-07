package com.study.proxy.jdk.proxy3;

/**
 * Created by guodd on 2018/2/2.
 */
public class HelloServiceImpl implements HelloService {

    @Override
    public void sayHello(String str) {
        System.out.println("我是" + str);
    }
}
