package com.study.spring.ioc.ioc1;

/**
 * Created by guodd on 2018/2/7.
 */
public class StudentUserService implements UserService {
    @Override
    public void sayHello() {
        System.out.println("I am a student");
    }
}
