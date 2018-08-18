package com.owen.javabasic.proxy;

import com.owen.models.common.Cat;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CglibProxy implements MethodInterceptor
{
    private Object obj;
    public Object getProxy(Class clazz)
    {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(clazz);
        enhancer.setCallback(this);
        return enhancer.create();
    }

    public static void main(String[] args)
    {
        CglibProxy proxy = new CglibProxy();
        Cat cat = (Cat)proxy.getProxy(Cat.class);
        cat.walk();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable
    {
        System.out.println("Cglib before invoke...");
        methodProxy.invokeSuper(o, objects);
        System.out.println("Cglib after invoke...");
        return null;
    }
}
