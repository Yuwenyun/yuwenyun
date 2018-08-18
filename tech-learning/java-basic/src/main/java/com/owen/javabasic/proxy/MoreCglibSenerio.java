package com.owen.javabasic.proxy;

import com.owen.models.common.Employee;
import net.sf.cglib.proxy.Callback;
import net.sf.cglib.proxy.CallbackFilter;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.NoOp;

import java.lang.reflect.Method;

public class MoreCglibSenerio
{
    public static void main(String[] args)
    {
        // single callback
        System.out.println("Single callback..........");
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(Employee.class);
        enhancer.setCallback(new EmployeeGetAgeInterceptor());
        Employee proxy = (Employee)enhancer.create();
        proxy.getAge();

        // multi-callback
        System.out.println("Multi callback..........");
        enhancer.setCallbacks(new Callback[]{new EmployeeGetNameInterceptor(), new EmployeeGetAgeInterceptor()});
        proxy = (Employee)enhancer.create();
        proxy.getName();
        proxy.getAge();

        // add interceptor filter for method
        System.out.println("Callback with filters..........");
        enhancer.setCallbackFilter(new CallbackFilter()
        {
            @Override
            public int accept(Method method)
            {
                switch (method.getName()){
                    case "getName":
                        return 0;
                    case "getAge":
                        return 1;
                    default:
                        return 0;
                }
            }
        });
        proxy = (Employee)enhancer.create();
        proxy.getName();
        proxy.getAge();

        // no callback
        System.out.println("Add no callback to filter..........");
        enhancer.setCallbacks(new Callback[]{new EmployeeGetNameInterceptor()
                , new EmployeeGetAgeInterceptor(), NoOp.INSTANCE});
        enhancer.setCallbackFilter(new CallbackFilter()
        {
            @Override
            public int accept(Method method)
            {
                switch (method.getName()){
                    case "getName":
                        return 0;
                    case "getAge":
                        return 1;
                    default:
                        return 2;
                }
            }
        });
        proxy = (Employee)enhancer.create();
        proxy.getName();
        proxy.getAge();
        System.out.println(proxy.isMale());
    }
}
