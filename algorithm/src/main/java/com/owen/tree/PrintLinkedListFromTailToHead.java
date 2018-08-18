package com.owen.tree;

import java.util.Stack;
import com.owen.models.algorithm.Node;
import com.owen.utils.format.TreeGenerator;

public class PrintLinkedListFromTailToHead implements Runnable
{
    @Override
    public void run()
    {
        Node<Integer> list = TreeGenerator.getListOfNodes();
        Stack<Integer> stack = readIntoStack(list);
        System.out.println();
        while(!stack.empty()){
            System.out.print(stack.pop() + " ");
        }
    }

    private <T> Stack<T> readIntoStack(Node<T> root)
    {
        Node<T> next = root;
        Stack<T> stack = new Stack<>();
        while(next != null){
            stack.push(next.getValue());
            next = next.getNext();
        }
        return stack;
    }
}
