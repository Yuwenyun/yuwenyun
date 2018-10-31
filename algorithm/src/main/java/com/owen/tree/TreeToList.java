package com.owen.tree;

import com.owen.models.algorithm.Node;
import com.owen.utils.format.TreeGenerator;

public class TreeToList
{
    public static void main(String[] args)
    {
        Node<Integer> root = TreeGenerator.getSampleTree();
        root = convertToList(root);
        while(root != null && root.getRight() != null){
            System.out.println(root.getValue());
            root = root.getRight();
        }
    }

    private static Node<Integer> convertToList(Node<Integer> root)
    {
        if(root == null){ return null; }
        Node<Integer> head = findLeftMostNode(root);
        Node<Integer> last = null;
        convert(root, last);
        return head;
    }

    private static Node<Integer> convert(Node<Integer> root, Node<Integer> last)
    {
        if(root == null){ return null; }
        if(root.getLeft() != null){
            last = convert(root.getLeft(), last);
        }
        root.setLeft(last);
        if(last != null){
            last.setRight(root);
        }
        last = root;
        if(root.getRight() != null){
            last = convert(root.getRight(), last);
        }
        return last;
    }

    private static Node<Integer> findLeftMostNode(Node<Integer> root)
    {
        if(root == null){ return null; }
        Node<Integer> leftChild = findLeftMostNode(root.getLeft());
        if(leftChild == null){
            return root;
        }
        else{
            return leftChild;
        }
    }
}
