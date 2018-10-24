package com.owen.spring.bean;

public class HelloServiceImpl2 implements HelloService
{
    @Override
    public void sayHi()
    {
        System.out.println("HelloServiceImpl2.sayHi()...");
    }

    @Override
    public void sayHello()
    {
        System.out.println("HelloServiceImpl2.sayHello()...");
    }
}
