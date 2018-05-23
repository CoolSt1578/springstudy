package com.study.proxy.cglib.proxy2;

import net.sf.cglib.core.DebuggingClassWriter;
import net.sf.cglib.proxy.Enhancer;

/**
 * Created by guodd on 2018/2/5.
 */
public class CGLibRunner {

    public static void main(String[] args) {

        Enhancer enhancer = new Enhancer();
        //设置需要创建子类的类，clazz就是需要代理的真实对象的实例
        enhancer.setSuperclass(RealSubject.class);
        enhancer.setCallback(new CGLibProxy());
        //通过字节码技术动态创建子类实例
        RealSubject realSubjectProxy = (RealSubject) enhancer.create();

        // 关键部分，打开生成字节码文件功能。会将生成的字节码文件生成到work
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "F:\\work");
        CGLibProxy cgLibProxy = new CGLibProxy();
        //通过生成子类的方式创建代理类

        //com.study.proxy.cglib.proxy2.RealSubject$$EnhancerByCGLIB$$67968b7c
        System.out.println(realSubjectProxy.getClass().getName());
        //class com.study.proxy.cglib.proxy2.RealSubject
        System.out.println(realSubjectProxy.getClass().getSuperclass());
        realSubjectProxy.doSomething();
    }
}
