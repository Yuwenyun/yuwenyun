package com.owen.tree;

import java.util.LinkedList;
import java.util.Queue;

public class ImplementStackWithTwoQueues<T>
{
    private Queue<T> queue1 = new LinkedList<>();
    private Queue<T> queue2 = new LinkedList<>();

    public void push(T t)
    {
        queue1.add(t);
    }

    public T pop()
    {
        if(queue1.isEmpty()){
            if(queue2.isEmpty()){
                return null;
            }
            while(!queue2.isEmpty() && queue2.size() != 1){
                T value = queue2.remove();
                queue1.add(value);
            }
            return queue2.remove();
        }
        else{
            while(!queue1.isEmpty() && queue1.size() != 1){
                T value = queue1.remove();
                queue2.add(value);
            }
            return queue1.remove();
        }
    }
}
