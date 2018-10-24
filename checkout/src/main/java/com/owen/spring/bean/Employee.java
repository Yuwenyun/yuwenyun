package com.owen.spring.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.lang.Nullable;

public class Employee implements InitializingBean, BeanNameAware, BeanFactoryAware, ApplicationContextAware
{
//    @RoutingInjected
//    private HelloService service;

    private String name;
    private int age;

    public void init()
    {
        System.out.println("Employee.init()...");
    }

    public void destroy()
    {
        System.out.println("Employee.destroy()...");
    }

    @Override
    public void afterPropertiesSet() throws Exception
    {
        System.out.println("InitializingBean.afterPropertiesSet()...");
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException
    {
        System.out.println("BeanFactoryAware.setBeanFactory()...");
    }

    @Override
    public void setBeanName(String s)
    {
        System.out.println("BeanNameAware.setBeanName()...");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException
    {
        System.out.println("ApplicationContextAware.setApplicationContext()...");
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        System.out.println("setName()...");
        this.name = name;
    }

    public int getAge()
    {
        return age;
    }

    public void setAge(int age)
    {
        System.out.println("setAge()...");
        this.age = age;
    }

//    public HelloService getService()
//    {
//        return service;
//    }
//
//    public void setService(HelloService service)
//    {
//        this.service = service;
//    }
}
