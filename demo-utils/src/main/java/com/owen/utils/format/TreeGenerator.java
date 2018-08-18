package com.owen.utils.format;

import com.owen.models.algorithm.Node;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class TreeGenerator
{
    private final static String space = " ";
    private final static String forwardSlash = "/";
    private final static String backwardSlash = "\\";

    public static Node<Integer> getDuplicateEleTree()
    {
        Node<Integer> root = new Node<>(3);
        Node<Integer> node1 = new Node<>(1);
        Node<Integer> node2 = new Node<>(9);
        Node<Integer> node3 = new Node<>(6);
        Node<Integer> node4 = new Node<>(8);
        Node<Integer> node5 = new Node<>(8);
        Node<Integer> node6 = new Node<>(2);
        Node<Integer> node7 = new Node<>(5);
        Node<Integer> node8 = new Node<>(4);
        Node<Integer> node9 = new Node<>(0);
        Node<Integer> node10 = new Node<>(7);
        root.setLeft(node1); root.setRight(node2);
        node1.setLeft(node3); node1.setRight(node4);
        node2.setLeft(node5); node2.setRight(node6);
        node3.setLeft(node7);
        node4.setLeft(node8); node4.setRight(node9);
        node5.setLeft(node10);

        printTree(root);

        return root;
    }

    public static Node<Integer> getListOfNodes()
    {
        Node<Integer> root = new Node<>(3);
        Node<Integer> node1 = new Node<>(1);
        Node<Integer> node2 = new Node<>(9);
        Node<Integer> node3 = new Node<>(6);
        Node<Integer> node4 = new Node<>(8);
        Node<Integer> node5 = new Node<>(8);
        Node<Integer> node6 = new Node<>(2);
        Node<Integer> node7 = new Node<>(5);
        Node<Integer> node8 = new Node<>(4);
        Node<Integer> node9 = new Node<>(0);
        Node<Integer> node10 = new Node<>(7);

        root.setNext(node1);
        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);
        node4.setNext(node5);
        node5.setNext(node6);
        node6.setNext(node7);
        node7.setNext(node8);
        node8.setNext(node9);
        node9.setNext(node10);

        printList(root);

        return root;
    }

    public static <T> void printList(Node<T> root)
    {
        System.out.print(root.getValue() + space);
        if(root.getNext() == null) {
            return;
        }
        else{
            printList(root.getNext());
        }
    }

    public static <T> void printTree(Node<T> root)
    {
        int maxLevel = maxLevel(root);
        printTree(Collections.singletonList(root), 1, maxLevel);
    }

    // print the tree line by line
    private static <T> void printTree(List<Node<T>> nodes, int level, int maxLevel)
    {
        if(nodes.isEmpty() || nodes.stream().allMatch(Objects::isNull)){
            return;
        }

        int floor = maxLevel - level;
        int heightOfLinesBetweenLevel = (int)Math.pow(2, floor - 1);
        int headSpacesCountBeforeChar = (int)Math.pow(2, floor) - 1;
        int betweenSpacesCountBetweenChilds = (int)Math.pow(2, floor + 1) - 1;

        // print space of the line before print any char
        printSpace(headSpacesCountBeforeChar);

        // print the char and prepare it's child nodes
        List<Node<T>> childNodes = new ArrayList<>();
        for(Node<T> node : nodes){
            if(node != null){
                System.out.print(node.getValue());
                childNodes.add(node.getLeft());
                childNodes.add(node.getRight());
            }
            // add null to the list making it like a full tree
            else{
                childNodes.add(null);
                childNodes.add(null);
                System.out.print(space);
            }
            printSpace(betweenSpacesCountBetweenChilds);
        }
        System.out.println("");

        // print forward/backward slashes
        for(int i = 1; i <= heightOfLinesBetweenLevel; i++){
            for(int j = 0; j < nodes.size(); j++){
                printSpace(headSpacesCountBeforeChar - i);

                if(nodes.get(j) == null){
                    printSpace(2 * heightOfLinesBetweenLevel + i + 1);
                    continue;
                }

                if(nodes.get(j).getLeft() != null){
                    System.out.print(forwardSlash);
                }
                else{
                    printSpace(1);
                }

                printSpace(2 * i - 1);

                if(nodes.get(j).getRight() != null){
                    System.out.print(backwardSlash);
                }
                else{
                    printSpace(1);
                }

                printSpace(2 * heightOfLinesBetweenLevel - i);
            }
            System.out.println("");
        }

        printTree(childNodes, level + 1, maxLevel);
    }

    private static <T> int maxLevel(Node<T> node)
    {
        if(node == null){
            return 0;
        }
        return Math.max(maxLevel(node.getLeft()), maxLevel(node.getRight())) + 1;
    }

    private static void printSpace(int count)
    {
        System.out.print(new String(new char[count]).replace("\0", space));
    }
}
