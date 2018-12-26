package com.study.spring.aop.aop5;

import org.springframework.aop.AfterReturningAdvice;

import java.lang.reflect.Method;

/**
 * Created by guodd on 2018/1/30.
 */
public class TicketServiceAfterReturningAdvice implements AfterReturningAdvice {

    public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
        System.out.println("After Returning:服务完毕。。。");
    }
}
