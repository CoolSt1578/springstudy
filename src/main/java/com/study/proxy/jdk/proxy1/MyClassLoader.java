package com.study.proxy.jdk.proxy1;

/**
 * Created by guodd on 2018/1/31.
 */
public class MyClassLoader extends ClassLoader {

    public Class<?> defineMyClass(byte[] b , int off, int len){
        return super.defineClass(b, off, len);
    }
}
