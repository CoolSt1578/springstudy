package com.study.proxy.jdk.proxy4;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by guodd on 2018/2/2.
 */
public class DynamicSubject implements InvocationHandler {

    private Object object;

    public DynamicSubject(Object object){
        this.object = object;
    }

    /**
     * 这个方法不是显示调用
     * @param proxy 代理类实例
     * @param method 调用的方法
     * @param args  方法参数
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before calling :" + method);
        method.invoke(object, args);
        System.out.println("after calling :" + method);
        return null;
    }
}
