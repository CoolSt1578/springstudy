package com.study.proxy.jdk.proxy4;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * http://paddy-w.iteye.com/blog/841798
 * invoke方法的第一个参数有什么用
 * Created by guodd on 2018/2/2.
 */
public class Test {

    public static void main(String[] args) {
        //指定委托类
        Subject realSubject = new RealSubject();
        //绑定委托类和调用处理器 invoke方法
        InvocationHandler invocationHandler = new DynamicSubject(realSubject);
        Class<?> cls = realSubject.getClass();

        //生成代理
        Subject subject = (Subject) Proxy.newProxyInstance(cls.getClassLoader(), cls.getInterfaces(), invocationHandler);
        //通过运行结果说明subject是Proxy的一个实例，这个实例实现了Subject接口
        System.out.println(subject instanceof Subject);

        //这里可以看出subject的Class
        System.out.println("subject 的 Class 类是：" + subject.getClass().toString());

        System.out.println("subject 的属性有：");
        Field[] fields = subject.getClass().getDeclaredFields();
        for(Field field : fields){
            System.out.print(field.getName() + ",");
        }
        System.out.println();

        System.out.println("subject 的方法有：");
        Method[] methods = subject.getClass().getDeclaredMethods();
        for(Method method : methods){
            System.out.print(method.getName() + ",");
        }
        System.out.println();

        System.out.println("subject的父类是：" + subject.getClass().getSuperclass());

        System.out.println("subject实现的接口是：");
        Class<?>[] classes = subject.getClass().getInterfaces();
        for(Class<?> clazz : classes){
            System.out.print(clazz + ",");
        }
        System.out.println();
        System.out.println("运行结果为：");
        subject.request();
    }
}
