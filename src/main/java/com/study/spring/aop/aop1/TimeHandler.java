package com.study.spring.aop.aop1;

/**
 * 切面增强处理
 * Created by guodd on 2018/1/29.
 */
public class TimeHandler {

    public void printTime(){
        System.out.println("CurrentTime = " + System.currentTimeMillis());
    }
}
