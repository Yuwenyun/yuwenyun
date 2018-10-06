package com.owen.proxy;

public class Man implements Person
{
    @Override
    public void talk()
    {
        System.out.println("Man talks");
    }

    @Override
    public void walk()
    {
        System.out.println("Man walks");
    }

    @Override
    public void work(int hour)
    {
        System.out.println("Worked " + hour + " hours");
    }
}
