package com.owen.classloader;

public class Janney
{
    public Janney(){
        System.out.println("class Janney");
    }

    public Janney(String hello){
        System.out.println(hello + " Janney");
    }

    {
        System.out.println("Janney");
    }

    static {
        System.out.println("static Janney");
    }
}
