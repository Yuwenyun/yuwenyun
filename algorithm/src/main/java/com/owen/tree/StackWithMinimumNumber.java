package com.owen.tree;

import java.util.Stack;

public class StackWithMinimumNumber
{
    private Stack<Integer> min = new Stack<Integer>();
    private Stack<Integer> stack = new Stack<Integer>();

    public static void main(String[] args)
    {
        StackWithMinimumNumber stack = new StackWithMinimumNumber();
        stack.push(5);
        stack.push(2);
        stack.push(6);
        stack.push(3);
        stack.push(1);

        System.out.println(stack.getMin());
        stack.pop();
        System.out.println(stack.getMin());
    }

    public void push(int a){
        if(min.isEmpty()){
            min.push(a);
        }
        else{
            if(a < min.peek()){
                min.push(a);
            }
        }
        stack.push(a);
    }

    public int pop(){
        if(stack.peek().equals(min.peek())){
            min.pop();
        }
        return stack.pop();
    }

    public int getMin(){
        return min.peek();
    }
}
