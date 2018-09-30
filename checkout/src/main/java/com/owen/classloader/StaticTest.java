package com.owen.classloader;

public class StaticTest{

    public static int k = 0;
    public static StaticTest t1 = new StaticTest("t1");
    public static StaticTest t2 = new StaticTest("t2");
    public static int i = print("i");
    public static int n = 99;
    public int j = print("j");

    {
        print("Constructor block");
    }
    static {
        print("Static block");
    }

    public StaticTest(String str)
    {
        System.out.println((++k) + ":" + str + " i=" + i + " n=" + n);
        ++n;
        ++i;
    }

    public static int print(String str) {
        System.out.println((++k) + ":" + str + " i=" + i + " n=" + n);
        ++i;
        return ++n;
    }

    public static void main(String[] args)
    {
        StaticTest staticTest = new StaticTest("init");
    }
}