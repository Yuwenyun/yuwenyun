package com.owen.javabasic.proxy;

import com.owen.models.common.Animal;
import com.owen.models.common.Cat;

import java.lang.reflect.Proxy;

public class JDKProxy
{
    public static void main(String[] args)
    {
        // static proxy, demand a corresponding implementation of the
        // same interface as Cat did
        System.out.println("Static proxy....");
        Cat cat = new Cat();
        CatProxy proxy = new CatProxy(cat);
        proxy.run();
        proxy.walk();

        // dynamic proxy, demand a InvocationHandler instance, need the
        // proxied class to implement some interface
        System.out.println("Dynamic proxy....");
        // generate the .class file of the proxy which is dynamically generated.
        // this demand the dir /com/sun/proxy exists
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles","true");
        Animal animal = (Animal) Proxy.newProxyInstance(cat.getClass().getClassLoader(),
                cat.getClass().getInterfaces(), new MyInvocationHandler(cat));
        animal.run();
        animal.walk();
    }
}
