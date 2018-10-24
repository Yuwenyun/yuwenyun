package com.owen.spring.bean;

public class HelloServiceImpl1 implements HelloService
{
    @Override
    public void sayHi()
    {
        System.out.println("HelloServiceImpl1.sayHi()...");
    }

    @Override
    public void sayHello()
    {
        System.out.println("HelloServiceImpl1.sayHello()...");
    }
}
