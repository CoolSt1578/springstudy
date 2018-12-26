package com.study.spring.aop.aop1;

/**
 * Created by guodd on 2018/1/29.
 */
public class LogHandler {

    public void logBefore(){
        System.out.println("Log before method");
    }

    public void logAfter(){
        System.out.println("Log after method");
    }
}
