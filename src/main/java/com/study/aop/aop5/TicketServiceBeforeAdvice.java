package com.study.aop.aop5;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * Created by guodd on 2018/1/30.
 */
public class TicketServiceBeforeAdvice implements MethodBeforeAdvice {
    public void before(Method method, Object[] args, Object target) throws Throwable {
        System.out.println("Before Advice：欢饮光临售票点。。。");
    }
}
