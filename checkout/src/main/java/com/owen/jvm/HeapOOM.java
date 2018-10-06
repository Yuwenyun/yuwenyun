package com.owen.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * JVM options:
 * -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8 -XX:+HeapDumpOnOutOfMemoryError
 */
public class HeapOOM
{
    public static void main(String[] args)
    {
        List<OOMObject> list = new ArrayList<>();
        while(true){
            list.add(new OOMObject());
        }
    }
    static class OOMObject{}
}
