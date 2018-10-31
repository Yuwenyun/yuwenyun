package com.owen.tree;

import com.owen.models.algorithm.Node;
import com.owen.utils.format.TreeGenerator;

public class ReverseLinkedList
{
    public static void main(String[] args)
    {
        Node<Integer> list = TreeGenerator.getListOfNodes();
        Node<Integer> head = reverseList(list);
        System.out.println("result:");
        while(head != null){
            System.out.print(head.getValue() + " ");
            head = head.getNext();
        }
    }

    private static Node<Integer> reverseList(Node<Integer> list)
    {
        if(list == null){ return null; }
        Node<Integer> currNode = list, nextNode = list.getNext(), latterNode;
        list.setNext(null);
        while(nextNode != null){
            latterNode = nextNode.getNext();
            nextNode.setNext(currNode);
            currNode = nextNode;
            nextNode = latterNode;
        }
        return currNode;
    }
}
