package com.study.proxy.jdk.proxy2;

import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * Created by guodd on 2018/1/31.
 */
public class Test2 {
    public static void main(String[] args) throws IOException, IllegalAccessException, InstantiationException {
        ElectricCar car = new ElectricCar();
        //获取对应的classLoader
        ClassLoader classLoader = car.getClass().getClassLoader();
        //获取electricCar所实现的接口
        Class[] interfaces = car.getClass().getInterfaces();
        System.out.println(car.getClass());
        for(Class c : interfaces){
            System.out.println(c.getName());
        }

        System.out.println("========================");

        Class superClass = car.getClass().getSuperclass();
        Class[] superInterfaces = superClass.getInterfaces();
        System.out.println(superClass.getName());
        for(Class c : superInterfaces){
            System.out.println(c.getName());
        }
        System.out.println("========================");

//        设置一个来自代理传过来的方法调用请求处理器。处理所有对象上的方法调用
        InvocationHandler invocationHandler = new InvocationHandlerImpl(car);
        /**
         * 根据上面这些信息，创建代理对象
         * 在这过程中
         * 1.jdk会根据传入的参数信息动态地在内存中创建和.class文件等同的字节码
         * 2.然后根据相应的字节码转换成对应的class
         * 3.然后调用newInstance()创建实例
         */
        Object object = Proxy.newProxyInstance(classLoader, interfaces, invocationHandler);
//        ProxyUtils.generateClassFile(car.getClass(), "ElectricCarProxy");
        //只能转换为目标类实现的接口，因为jdk动态代理针对的是接口，内部实现也是通过获取目标类实现的接口进行动态生成字节码
        Vehicle vehicle = (Vehicle) object;
        vehicle.drive();
        Rechargable rechargable = (Rechargable) object;
        rechargable.recharge();
        Testable testable = (Testable) object;
        testable.test();

        ProxyUtils.generateClassFile(car.getClass(), "ElectricCarProxy");
    }
}
