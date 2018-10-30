package com.owen.classloader;

public class Owen extends Janney
{
//    public Owen(){
//        System.out.println("class Owen");
//    }
    public Owen(String hello){
        System.out.println(hello + " Owen");
    }

    {
        System.out.println("Owen");
    }
    static{
        System.out.println("static Owen");
    }

    public static void main(String[] args){
        new Owen("Hello");
    }
}
