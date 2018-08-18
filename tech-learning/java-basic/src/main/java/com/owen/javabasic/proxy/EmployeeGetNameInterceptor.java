package com.owen.javabasic.proxy;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class EmployeeGetNameInterceptor implements MethodInterceptor
{
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable
    {
        System.out.println("EmployeeGetNameInterceptor invoke before...");
        Object result = methodProxy.invokeSuper(o, objects);
        System.out.println(result);
        System.out.println("EmployeeGetNameInterceptor invoke after...");
        return result;
    }
}
