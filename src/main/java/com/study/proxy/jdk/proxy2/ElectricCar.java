package com.study.proxy.jdk.proxy2;

/**
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
