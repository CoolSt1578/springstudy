package com.study.spring.aop.aop5;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * Created by guodd on 2018/1/30.
 */
public class TicketServiceAroundAdvice implements MethodInterceptor {

    public Object invoke(MethodInvocation invocation) throws Throwable {
        System.out.println("Around Advice:Begin...");
        Object returnValue = invocation.proceed();
        System.out.println("Around Advice:End....");
        return returnValue;
    }
}
