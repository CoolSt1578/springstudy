package com.study.proxy.jdk.proxy3;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by guodd on 2018/2/2.
 */
public class HelloServiceProxy implements InvocationHandler {

    private Object target;

    public HelloServiceProxy(Object target){
        this.target = target;
    }

    /**
     * 通过代理对象调用方法首先进入这个方法
     * @param proxy
     * @param method
     * @param args
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("begin invoke");
        method.invoke(target, args);
        System.out.println("end invoke");
        return null;
    }
}
