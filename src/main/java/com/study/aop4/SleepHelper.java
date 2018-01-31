package com.study.aop4;

/**
 * Created by guodd on 2018/1/29.
 */
public class SleepHelper {

    public void beforeSleep(){
        System.out.println("睡觉前要脱衣服");
    }

    public void afterSleep(){
        System.out.println("睡醒了要穿衣服");
    }
}
