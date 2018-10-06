package com.owen.proxy;

public class Employee
{
    public void work(int hour)
    {
        System.out.println("worked " + hour + " hours");
    }

    public void rest()
    {
        System.out.println("rest for a while");
    }

    public void say(String str)
    {
        System.out.println("Say that " + str);
    }

    public String getName()
    {
        System.out.println("About to get name");
        return "Janney";
    }

    public int getAge()
    {
        return 25;
    }
}
