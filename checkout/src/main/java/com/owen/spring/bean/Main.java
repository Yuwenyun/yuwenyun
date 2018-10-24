package com.owen.spring.bean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main
{
    public static void main(String[] args)
    {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Employee emp = (Employee)context.getBean("employee");
//        emp.getService().sayHello();
//        emp.getService().sayHi();
    }
}
