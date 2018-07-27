package com.study.spring.ioc.simple_ioc;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * 简单IOC实现，按以下步骤
 * 加载 xml 配置文件，遍历其中的 <bean> 标签
 * 获取<bean>标签中的 id 和 class 属性，加载 class 属性对应的类，并创建 bean
 * 遍历 <bean> 标签中的 <property> 标签，获取属性值，并将属性值填充到 bean 中
 * 将 bean 注册到 bean 容器中
 * Created by guodd on 2018/7/27.
 */
public class SimpleIOC {

    private Map<String, Object> beanMap = new HashMap<>();

    public SimpleIOC(String location) throws Exception {
        loadResource(location);
    }

    /**
     * @param beanName
     * @return
     */
    public Object getBean(String beanName){
        Object bean = beanMap.get(beanName);
        if(bean == null){
            throw new IllegalArgumentException("there is no bean with name: " + beanName);
        }
        return bean;
    }

    private void loadResource(String location) throws Exception {
        InputStream in = new FileInputStream(location);
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = factory.newDocumentBuilder();
        Document document = documentBuilder.parse(in);
        Element root = document.getDocumentElement();
        NodeList nodes = root.getChildNodes();
        for(int i=0; i<nodes.getLength(); i++){
            Node node = nodes.item(i);
            if(node instanceof Element){
                Element ele = (Element) node;
                String id = ele.getAttribute("id");
                String className = ele.getAttribute("class");

                //加载Class
                Class beanClass = null;
                try{
                    beanClass = Class.forName(className);
                }catch (ClassNotFoundException e){
                    e.printStackTrace();
                    return;
                }

                //创建bean
                Object bean = beanClass.newInstance();

                //遍历<property>标签
                NodeList propertyNodes = ele.getElementsByTagName("property");
                for(int j=0; j<propertyNodes.getLength(); j++){
                    Node propertyNode = propertyNodes.item(j);
                    if(propertyNode instanceof Element){
                        Element propertyEle = (Element) propertyNode;
                        String name = propertyEle.getAttribute("name");
                        String value = propertyEle.getAttribute("value");

                        //利用反射将相关bean的字段访问权限设为可访问
                        Field declaredField = bean.getClass().getDeclaredField(name);
                        declaredField.setAccessible(true);

                        if(value != null && value.length() > 0){
                            declaredField.set(bean, value);
                        }else{
                            String ref = propertyEle.getAttribute("ref");
                            if(ref == null || ref.length() == 0){
                                throw new IllegalArgumentException(("ref config error"));
                            }
                            declaredField.set(bean, getBean(ref));
                        }
                    }
                }
                registerBean(id, bean);
            }
        }
    }

    private void registerBean(String id, Object bean) {
        beanMap.put(id, bean);
    }
}
