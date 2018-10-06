package com.owen.proxy;

import net.sf.cglib.proxy.Callback;
import net.sf.cglib.proxy.CallbackFilter;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.NoOp;

import java.lang.reflect.Method;

public class CglibTest
{
    public static void main(String[] args)
    {
        // use Enhancer.java to create the proxy object
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(Employee.class);

        // set a bunch of callbacks
        enhancer.setCallbacks(new Callback[]{new WorkInterceptor(), new RestInterceptor(), NoOp.INSTANCE, new FixedValue()});
        // add filter for different callbacks
        enhancer.setCallbackFilter(new CallbackFilter()
        {
            @Override
            public int accept(Method method)
            {
                if(method.getName().equals("work")){
                    return 0;
                }
                else if(method.getName().equals("rest")){
                    return 1;
                }
                else if(method.getName().equals("say")){
                    return 2;
                }
                else{
                    return 3;
                }
            }
        });
        Employee emp = (Employee)enhancer.create();
        emp.work(4);
        emp.rest();
        emp.say("Hello Owen");
        System.out.println(emp.getName());
    }
}
