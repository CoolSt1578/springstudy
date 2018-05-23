package com.study.aop.aop5;

import org.aopalliance.aop.Advice;
import org.springframework.aop.framework.ProxyFactoryBean;

/**
 * AOP实现原理
 * http://blog.csdn.net/luanlouis/article/details/51155821
 * Created by guodd on 2018/1/30.
 */
public class Main {

    public static void main(String[] args) {
        Advice beforeAdvice = new TicketServiceBeforeAdvice();
        Advice afterReturningAdvice = new TicketServiceAfterReturningAdvice();
        Advice aroudAdvice = new TicketServiceAroundAdvice();
        Advice throwsAdvice = new TicketServiceThrowsAdvice();

        RailwayStation railwayStation = new RailwayStation();

        //创建ProxyFactoryBean，用来创建指定对象的proxy对象
        ProxyFactoryBean proxyFactoryBean = new ProxyFactoryBean();
        //设置Proxy的接口
        proxyFactoryBean.setInterfaces(TicketService.class);
        //设置realSubject
        proxyFactoryBean.setTarget(railwayStation);
        //proxy感兴趣的advice列表
        proxyFactoryBean.addAdvice(beforeAdvice);
        proxyFactoryBean.addAdvice(afterReturningAdvice);
        proxyFactoryBean.addAdvice(aroudAdvice);
        proxyFactoryBean.addAdvice(throwsAdvice);
        //使用JDK基于接口实现机制的动态代理生成Proxy代理对象，如果要是用CGLIB，需要把flag设为true
        proxyFactoryBean.setProxyTargetClass(false);
        //通过ProxyFactoryBean生成Proxy对象
        TicketService ticketService = (TicketService) proxyFactoryBean.getObject();
        ticketService.sellTicket();
    }
}
