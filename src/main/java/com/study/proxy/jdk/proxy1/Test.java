package com.study.proxy.jdk.proxy1;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by guodd on 2018/1/31.
 */
public class Test {

    public static void main(String[] args) throws IOException, IllegalAccessException, InstantiationException {
        File file = new File(".");
        System.out.println(file.getCanonicalPath());
        InputStream input = new FileInputStream(file.getCanonicalPath() + "\\target\\classes\\com\\study\\proxy\\proxy2\\ElectricCarProxy.class");
        byte[] result = new byte[4096];

        int count = input.read(result);
        System.out.println(count);
        //将字节码转换为对应的class对象
        MyClassLoader classLoader = new MyClassLoader();
        Class clazz = classLoader.defineMyClass(result, 0, count);
        //测试是否成功，打印class的信息
        System.out.println(clazz.getCanonicalName());

        Object object = clazz.newInstance();
        try{
            clazz.getMethod("drive", null).invoke(object, null);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
