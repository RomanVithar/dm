package com.company.tree;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

public class Tree {
    private Node root;

    public void insert(int value) {
        if (root == null) {
            root = new Node(value);
            return;
        }
        Node current = root;
        while (current != null) {
            if (value > current.value) {
                if(current.right == null){
                    current.right = new Node(value);
                    return;
                }
                current = current.right;
            } else {
                if(current.left == null){
                    current.left = new Node(value);
                    return;
                }
                current = current.left;
            }
        }
    }

    //глубь
    public void depthFirstWalk() {
        depthFirstWalk(root);
        System.out.println();
    }

    public void depthFirstWalk(Node current) {
        if (current.left != null) {
            depthFirstWalk(current.left);
        }
        if (current.right != null) {
            depthFirstWalk(current.right);
        }
        System.out.print(current.value+" ");
    }


    //ширь
    public void breadthFirstWalk() {
        Deque<Node> deque = new ArrayDeque<>();
        deque.addFirst(root);
        while (!deque.isEmpty()) {
            System.out.print(deque.getLast().value+" ");
            if (deque.getLast().left != null) {
                deque.addFirst(deque.getLast().left);
            }
            if (deque.getLast().right != null) {
                deque.addFirst(deque.getLast().right);
            }
            deque.pollLast();
        }
        System.out.println();
    }
}
