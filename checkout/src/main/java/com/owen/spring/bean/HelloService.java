package com.owen.spring.bean;

@RoutingSwitch("hello.switch")
public interface HelloService
{
    void sayHi();

    @RoutingSwitch("A")
    void sayHello();
}
