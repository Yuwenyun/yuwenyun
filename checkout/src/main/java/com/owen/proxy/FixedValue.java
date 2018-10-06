package com.owen.proxy;

public class FixedValue implements net.sf.cglib.proxy.FixedValue
{
    @Override
    public Object loadObject() throws Exception
    {
        return "Owen";
    }
}
