package com.study.spring.ioc.ioc2;

import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.PropertyValue;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.ConstructorArgumentValues;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Created by guodd on 2018/2/9.
 */
public class Test {

    public static void main(String[] args) {
        DefaultListableBeanFactory beanRegistry = new DefaultListableBeanFactory();
        BeanFactory container = bindViaCode(beanRegistry);
        FXNewProvider newProvider = (FXNewProvider) container.getBean("");
    }

    public static BeanFactory bindViaCode(BeanDefinitionRegistry registry){
        //Bean定义
        AbstractBeanDefinition newsProvider = new RootBeanDefinition(FXNewProvider.class);
        AbstractBeanDefinition newListener = new RootBeanDefinition(CCTVNewsListener.class);
        AbstractBeanDefinition newPersister = new RootBeanDefinition(CCTVNewsPersister.class);
        //将bean定义注册到容器中
        registry.registerBeanDefinition("fxNewProvider", newsProvider);
        registry.registerBeanDefinition("cctvNewListener", newListener);
        registry.registerBeanDefinition("cctvNewsPersister", newPersister);
        //指定依赖关系
        //1.可以通过构造方法注入方式
        ConstructorArgumentValues argValues = new ConstructorArgumentValues();
        argValues.addIndexedArgumentValue(0, newListener);
        argValues.addIndexedArgumentValue(1, newPersister);
        newsProvider.setConstructorArgumentValues(argValues);
        //2.或者通过setter方法注入方式
        MutablePropertyValues propertyValues = new MutablePropertyValues();
        propertyValues.addPropertyValue(new PropertyValue("newsListener", newListener));
        propertyValues.addPropertyValue(new PropertyValue("newsPersister", newPersister));
        newsProvider.setPropertyValues(propertyValues);
        //绑定完成
        return (BeanFactory) registry;
    }
}
