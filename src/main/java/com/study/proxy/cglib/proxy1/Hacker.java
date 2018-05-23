package com.study.proxy.cglib.proxy1;


import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Created by guodd on 2018/2/1.
 */
public class Hacker implements MethodInterceptor {
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("===================I am a hacker, Let's see what the poor programmer doing now ...");
        methodProxy.invokeSuper(o, objects);
        System.out.println("===================Oh, what a poor programmer ...");
        return null;
    }
}
