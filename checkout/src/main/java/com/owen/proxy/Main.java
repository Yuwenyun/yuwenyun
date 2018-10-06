package com.owen.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Main
{
    private static Man man = new Man();

    public static void main(String[] args)
    {
        Person person = (Person)Proxy.newProxyInstance(Person.class.getClassLoader(), new Class[]{Person.class}, new InvocationHandler()
        {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable
            {
                method.invoke(man, args);
                System.out.println("Hello Proxy");
                return null;
            }
        });

        person.talk();
        person.walk();
        person.work(5);
    }
}
