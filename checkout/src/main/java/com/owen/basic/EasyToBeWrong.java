package com.owen.basic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EasyToBeWrong
{
    public static void main(String[] args)
    {
        // IntegerCache in Integer will cache those between -128 to 127
        Integer one = 128, two = 128;
        Integer three = 100, four = 100;
        System.out.println(one == two); // false
        System.out.println(three == four);  // true

        // auto-unbox, it will be a copy of the Integer
        Integer total = 0;
        paramCheck(total);
        System.out.println(total);  // 0

        // asList() will return type List.ArrayList, which is
        // immutable, unable to add/remove
        List<String> list = Arrays.asList("Owen", "Janney", "Sam");
        list.add("Jack"); // throw an exception

        // list will check modCount when add/remove in for loop
        // throw concurrentModificationException
        List<String> list1 = new ArrayList<>();
        list1.add("Owen");
        list1.add("Janney");
        for(String name : list1){
            if("Janney".equals(name)){
                list1.remove(name); // throw an exception
            }
        }

        // unlimited loop
        int count = 0, end = Integer.MAX_VALUE, start = end - 2;
        for(int i = start; i <= end; i++){
            count++;
        }
        System.out.println(count);

        System.out.println(findResult());
    }

    @SuppressWarnings("finally")
    public static boolean findResult(){
        try{
            return true;
        }catch (Exception e){
            return true;
        }finally {
            return false;
        }
    }

    private static void paramCheck(Integer total)
    {
        if(total < 1){
            total += 1;
        }
    }
}
