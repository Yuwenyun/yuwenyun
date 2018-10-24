package com.owen.spring.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class RoutingBeanPostProcessor implements BeanPostProcessor
{
    @Nullable
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException
    {
        System.out.println("RoutingBeanPostProcessor.postProcessBeforeInitialization()...");
        return bean;
    }

    @Nullable
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException
    {
        System.out.println("RoutingBeanPostProcessor.postProcessBeforeInitialization()...");
        return null;
    }
}
