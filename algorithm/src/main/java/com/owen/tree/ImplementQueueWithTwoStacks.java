package com.owen.tree;

import java.util.Stack;

public class ImplementQueueWithTwoStacks<T>
{
    private Stack<T> stack1 = new Stack<>();
    private Stack<T> stack2 = new Stack<>();

    public void push(T value)
    {
        stack1.push(value);
    }

    public T pop()
    {
        if(stack2.isEmpty()){
            if(stack1.isEmpty()){
                return null;
            }
            while(!stack1.isEmpty()){
                T t = stack1.pop();
                stack2.push(t);
            }
        }
        return stack2.pop();
    }
}
