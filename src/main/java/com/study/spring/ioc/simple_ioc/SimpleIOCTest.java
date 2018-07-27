package com.study.spring.ioc.simple_ioc;

import com.study.spring.ioc.simple_ioc.entity.Car;
import com.study.spring.ioc.simple_ioc.entity.Wheel;

/**
 * Created by guodd on 2018/7/27.
 */
public class SimpleIOCTest {

    public static void main(String[] args) {
        try {
            String location = SimpleIOC.class.getClassLoader().getResource("simpleioc.xml").getFile();
            System.out.println(location);
            SimpleIOC ioc = new SimpleIOC(location);
            Wheel wheel = (Wheel) ioc.getBean("wheel");
            Car car = (Car) ioc.getBean("car");

            System.out.println(wheel);
            System.out.println(car);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
