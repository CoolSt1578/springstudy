package com.study.proxy.cglib.proxy2;


import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Created by guodd on 2018/2/5.
 */
public class CGLibProxy implements MethodInterceptor {

    /**
     * 实现MethodInterceptor接口
     * @param o 目标对象
     * @param method 目标类方法的反射对象
     * @param args 参数
     * @param methodProxy 代理类实例
     * @return
     * @throws Throwable
     */
    @Override
    public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        System.out.println("before call doSomething");
        System.out.println(method);
        //调用具体目标对象的方法 invokeSuper
        //如果调用的是 Object obj = methodProxy.invoke(o, args);
        //会引发内存溢出
        Object obj = methodProxy.invokeSuper(o, args);
        System.out.println("after call doSomething");
        return null;
    }


}
