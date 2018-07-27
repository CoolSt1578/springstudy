package com.study.spring.ioc.ioc2.lookup_method;

import net.sf.cglib.core.DebuggingClassWriter;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by guodd on 2018/7/25.
 */
public class Main {

    public static void main(String[] args) {
        // 关键部分，打开生成字节码文件功能。会将生成的字节码文件生成到work
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "F:\\work");
        ApplicationContext context = new ClassPathXmlApplicationContext("ioc2.xml");

        NewsProvider newsProvider = (NewsProvider) context.getBean("newsProvider");
        System.out.println(newsProvider);

        News news1 = newsProvider.getNews();
        News news2 = newsProvider.getNews();

        System.out.println(news1);
        System.out.println(news2);

    }
}
