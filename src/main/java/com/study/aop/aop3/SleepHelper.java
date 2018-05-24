package com.study.aop.aop3;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 * Created by guodd on 2018/1/29.
 */
@Aspect
public class SleepHelper {

    public SleepHelper(){}

    @Pointcut("execution(* *.sleep())")
    public void sleeppoint(){
        System.out.println("切入点");
    }

    @Before(value = "sleeppoint()")
    public void beforeSleep() {
        System.out.println("睡觉前要脱衣服");
    }

    @After(value = "sleeppoint()")
    public void afterSleep(){

        System.out.println("起床前要穿衣服");
    }

    @AfterThrowing(value = "sleeppoint()", throwing = "ex")
    public void doThrowing(JoinPoint joinPoint, Throwable ex){
        System.out.println("doThrowing::method " + joinPoint.getTarget().getClass().getName() +
        "." + joinPoint.getSignature().getName() + " throw exception");
        System.out.println(ex.getMessage());
    }
}
