package com.study.proxy.jdk.proxy2;

/**
 * Java动态代理只能实现对接口的代理，不能实现对类的代理
 * 因为动态生成的字节码代理类需继承Proxy，就无法在继承目标类
 * Created by guodd on 2018/1/31.
 */
public class ElectricCar implements Vehicle, Rechargable {

    public ElectricCar(){}

    @Override
    public void drive() {
        System.out.println("ElectriCar is driving...");
    }

    @Override
    public void recharge() {
        System.out.println("ElectricCar is recharging...");
    }

    public void bee(){
        System.out.println("ElectricCar is beeing...");
    }
}
