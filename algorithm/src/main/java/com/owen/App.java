package com.owen;

import com.owen.models.algorithm.Node;
import com.owen.tree.ConstructTreeAccordingToPreAndInOrder;
import com.owen.tree.ImplementQueueWithTwoStacks;
import com.owen.tree.ImplementStackWithTwoQueues;
import com.owen.utils.format.TreeGenerator;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Node<Integer> root = new ConstructTreeAccordingToPreAndInOrder().constructTree(
                new Integer[]{1, 2, 4, 7, 3, 5, 6, 8},
                new Integer[]{4, 7, 2, 1, 5, 3, 8, 6}
        );
        TreeGenerator.printTree(root);

        ImplementStackWithTwoQueues<Integer> app = new ImplementStackWithTwoQueues<>();
        app.push(1);
        app.push(2);
        app.push(4);
        System.out.println(app.pop());
        app.push(7);
        app.push(3);
        System.out.println(app.pop());
        System.out.println(app.pop());
        System.out.println(app.pop());
    }
}
