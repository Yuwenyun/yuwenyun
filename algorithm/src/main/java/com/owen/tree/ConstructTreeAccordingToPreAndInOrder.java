package com.owen.tree;

import com.owen.models.algorithm.Node;

public class ConstructTreeAccordingToPreAndInOrder
{
    public <T> Node<T> constructTree(T[] pre, T[] in)
    {
        return constructTree(pre, 0, pre.length - 1, in, 0, in.length - 1);
    }

    private <T> Node<T> constructTree(T[] pre, int preStart, int preEnd, T[] in, int inStart, int inEnd)
    {
        if(preStart > preEnd || inStart > inEnd){
            return null;
        }
        Node<T> root = new Node<>(pre[preStart]);
        for(int i = inStart; i <= inEnd; i++){
            if(in[i].equals(root.getValue())){
                root.setLeft(constructTree(pre, preStart + 1, i, in, inStart, i - 1));
                root.setRight(constructTree(pre, i + 1, preEnd, in, i + 1, inEnd));
            }
        }
        return root;
    }
}
