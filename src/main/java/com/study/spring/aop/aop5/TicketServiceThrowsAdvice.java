package com.study.spring.aop.aop5;

import org.springframework.aop.ThrowsAdvice;

import java.lang.reflect.Method;

/**
 * Created by guodd on 2018/1/30.
 */
public class TicketServiceThrowsAdvice implements ThrowsAdvice{

    public void afterThrowing(Exception ex){
        System.out.println("After Throwing...");
    }

    public void afterThrowing(Method method, Object[] args, Object target, Exception ex){
        System.out.println("调用过程出错啦...");
    }
}
