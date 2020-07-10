package com.leetcode.medium;

import java.util.LinkedList;
import java.util.Queue;

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        this.val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        this.val = _val;
        this.left = _left;
        this.right = _right;
        this.next = _next;
    }
};

public class PopulatingNextRightPointsInEachNode116 {
    public Node connect(Node root) {
        if (root == null) {
            return root;
        }
        Queue<Node> nodes = new LinkedList<>();
        nodes.add(root);
        while (!nodes.isEmpty()) {
            int levelNum = nodes.size();
            for (int i = 0; i < levelNum; i++) {
                Node curNode = nodes.poll();
                if (i == (levelNum - 1)) {
                    curNode.next = null;
                } else {
                    Node nexNode = nodes.peek();
                    curNode.next = nexNode;
                }
                if (curNode.left != null) {
                    nodes.add(curNode.left);
                }
                if (curNode.right != null) {
                    nodes.add(curNode.right);
                }
            }
        }
        return root;
    }
}
