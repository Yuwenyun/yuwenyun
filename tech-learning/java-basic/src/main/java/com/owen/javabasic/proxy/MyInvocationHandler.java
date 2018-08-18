package com.owen.javabasic.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyInvocationHandler implements InvocationHandler
{
    private Object obj;
    public MyInvocationHandler(Object obj)
    {
        this.obj = obj;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable
    {
        System.out.println("MyInvocationHandler before invoke.");
        method.invoke(this.obj, args);
        System.out.println("MyInvocationHandler after invoke");
        return null;
    }
}
