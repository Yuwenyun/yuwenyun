package com.owen;

import com.owen.models.algorithm.Node;
import com.owen.tree.ConstructTreeAccordingToPreAndInOrder;
import com.owen.tree.ImplementQueueWithTwoStacks;
import com.owen.tree.ImplementStackWithTwoQueues;
import com.owen.utils.format.TreeGenerator;

/**
 * Hello world!
 *
 */
public class App 
{
    private static String input = "";

    public static void main( String[] args )
    {
        System.out.println(foo("0"));
        System.out.println(foo("1"));
        System.out.println(input);
        System.out.println(test());
    }

    private static String foo(String s)
    {
        try
        {
            if(s.equals("1")){
                throw new Exception();
            }
        }
        catch (Exception e){
            input += "2";
            return input;
        }
        finally
        {
            input += "3";
        }
        input += "4";
        return input;
    }

    private static boolean test()
    {
        try{
            return true;
        }
        finally
        {
            return false;
        }
    }
}
