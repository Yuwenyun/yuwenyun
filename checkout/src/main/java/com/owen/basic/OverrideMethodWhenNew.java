package com.owen.basic;

public class OverrideMethodWhenNew
{
    public static void main(String[] args)
    {
        Object obj = new Object(){
            @Override
            public boolean equals(Object object)
            {
                return true;
            }
        };

        System.out.println(obj.equals("OK"));
    }
}
