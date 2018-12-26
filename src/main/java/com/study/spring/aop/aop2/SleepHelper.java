package com.study.spring.aop.aop2;

import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * 实现方法前通知、返回后通知
 * Created by guodd on 2018/1/29.
 */
public class SleepHelper implements MethodBeforeAdvice, AfterReturningAdvice {

    public void before(Method method, Object[] objects, Object o) throws Throwable {
        System.out.println("睡觉前要脱衣服");
    }

    public void afterReturning(Object o, Method method, Object[] objects, Object o1) throws Throwable {
        System.out.println("起床后要穿衣服");
    }

}
