package com.owen.classloader;

public class Janney
{
    public Janney(){
        System.out.println("class Janney");
    }

    {
        System.out.println("Janney");
    }

    static {
        System.out.println("static Janney");
    }
}
