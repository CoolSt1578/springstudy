package com.study.spring.ioc.ioc1;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

/**
 * Created by guodd on 2018/2/7.
 */
public class Test {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("ioc1.xml");
        UserService student = (UserService) context.getBean("studentUserService");
        student.sayHello();

        ApplicationContext fileContext = new FileSystemXmlApplicationContext("G:\\study_prj\\git_prj\\springstudy\\src\\main\\resources\\ioc1.xml");
        UserService teacher = (UserService) fileContext.getBean("teacherUserService");
        teacher.sayHello();

        ClassPathResource resource = new ClassPathResource("ioc1.xml");
        DefaultListableBeanFactory beanRegistry = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanRegistry);
        reader.loadBeanDefinitions(resource);
        UserService student1 = beanRegistry.getBean("studentUserService", UserService.class);
        student1.sayHello();
    }
}
