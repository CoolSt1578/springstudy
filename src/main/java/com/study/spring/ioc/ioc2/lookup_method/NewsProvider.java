package com.study.spring.ioc.ioc2.lookup_method;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * Created by guodd on 2018/7/25.
 */
public class NewsProvider implements ApplicationContextAware{

    private ApplicationContext context;

    private News news;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        context = applicationContext;
    }

    public News getNews() {
        return news;
    }

    public void setNews(News news) {
        this.news = news;
    }
}
