package com.study.spring.ioc.simple_ioc.entity;

/**
 * Created by guodd on 2018/7/27.
 */
public class Wheel {

    private String brand;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Override
    public String toString() {
        return "Wheel{" + "brand='" + brand + '\'' + '}';
    }
}
