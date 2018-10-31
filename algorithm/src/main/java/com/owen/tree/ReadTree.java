package com.owen.tree;

import com.owen.models.algorithm.Node;
import com.owen.utils.format.TreeGenerator;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class ReadTree
{
    public static void main(String[] args)
    {
        // get sample tree
        Node<Integer> root = TreeGenerator.getSampleTree();

        // initialize result list
        LinkedList<Node<Integer>> pre_result = new LinkedList<>(),
                in_result = new LinkedList<>(),
                post_result = new LinkedList<>(),
                breadth_result = new LinkedList<>();

        pre_order(root, pre_result);
        in_order(root, in_result);
        post_order(root, post_result);
        breadth_first(root, breadth_result);

        // print out
        System.out.println("pre_order:");
        pre_result.forEach(node -> System.out.print(node.getValue() + " "));
        System.out.println();

        System.out.println("in_order:");
        in_result.forEach(node -> System.out.print(node.getValue() + " "));
        System.out.println();

        System.out.println("post_order:");
        post_result.forEach(node -> System.out.print(node.getValue() + " "));
        System.out.println();

        System.out.println("breadth_first:");
        breadth_result.forEach(node -> System.out.print(node.getValue() + " "));
        System.out.println();
    }

    private static void pre_order(Node<Integer> root, LinkedList<Node<Integer>> result)
    {
        result.add(root);
        if(root.getLeft() != null){
            pre_order(root.getLeft(), result);
        }

        if(root.getRight() != null){
            pre_order(root.getRight(), result);
        }
    }

    private static void in_order(Node<Integer> root, LinkedList<Node<Integer>> result)
    {
        if(root.getLeft() != null){
            in_order(root.getLeft(), result);
        }
        result.add(root);
        if(root.getRight() != null){
            in_order(root.getRight(), result);
        }
    }

    private static void post_order(Node<Integer> root, LinkedList<Node<Integer>> result)
    {
        if(root.getLeft() != null){
            post_order(root.getLeft(), result);
        }
        if(root.getRight() != null){
            post_order(root.getRight(), result);
        }
        result.add(root);
    }

    private static void breadth_first(Node<Integer> root, LinkedList<Node<Integer>> result)
    {
        Deque<Node<Integer>> temp = new ArrayDeque<>();
        temp.add(root);
        result.add(root);
        Node<Integer> currNode = null;
        while(!temp.isEmpty()){
            currNode = temp.poll();
            if(currNode.getLeft() != null){
                result.add(currNode.getLeft());
                temp.add(currNode.getLeft());
            }
            if(currNode.getRight() != null){
                result.add(currNode.getRight());
                temp.add(currNode.getRight());
            }
        }
    }
}
