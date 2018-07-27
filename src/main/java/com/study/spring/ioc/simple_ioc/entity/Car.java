package com.study.spring.ioc.simple_ioc.entity;

/**
 * Created by guodd on 2018/7/27.
 */
public class Car {

    private String name;

    private String length;

    private Wheel wheel;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public Wheel getWheel() {
        return wheel;
    }

    public void setWheel(Wheel wheel) {
        this.wheel = wheel;
    }

    @Override
    public String toString() {
        return "Car{" + "name='" + name + '\'' + ", length='" + length + '\'' + ", wheel=" + wheel + '}';
    }
}
