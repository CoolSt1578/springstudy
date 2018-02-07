package com.study.proxy.jdk.proxy4;

/**
 * Created by guodd on 2018/2/2.
 */
public class RealSubject implements Subject {

    @Override
    public void request() {
        System.out.println("From real subject.");
    }
}
