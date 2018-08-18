package com.owen.javabasic.proxy;

import com.owen.models.common.Animal;
import com.owen.models.common.Cat;

public class CatProxy implements Animal
{
    private Cat cat;
    public CatProxy(Cat cat)
    {
        this.cat = cat;
    }

    @Override
    public void walk()
    {
        System.out.println("Before proxy.");
        this.cat.walk();
        System.out.println("After proxy");
    }

    @Override
    public void run()
    {
        System.out.println("Before proxy.");
        this.cat.run();
        System.out.println("After proxy.");
    }
}
