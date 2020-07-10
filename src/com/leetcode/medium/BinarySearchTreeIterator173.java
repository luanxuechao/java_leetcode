package com.leetcode.medium;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinarySearchTreeIterator173 {

}

class BSTIterator {
    Queue<Integer> linked = new LinkedList<>();

    public BSTIterator(TreeNode root) {
        helper(root);
    }

    public void helper(TreeNode root) {
        if (root == null) {
            return;
        }
        helper(root.left);
        this.linked.offer(root.val);
        helper(root.right);
    }

    /** @return the next smallest number */
    public int next() {
        return this.linked.poll();
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return this.linked.peek() != null;
    }
}

class BSTIterator2 {
    Stack<TreeNode> stack = new Stack<>();
    TreeNode cur = null;

    public BSTIterator2(TreeNode root) {
        this.cur = root;
    }

    /** @return the next smallest number */
    public int next() {
        int res = -1;
        while (this.cur != null || !this.stack.isEmpty()) {
            // 节点不为空一直压栈
            while (this.cur != null) {
                this.stack.push(this.cur);
                this.cur = this.cur.left; // 考虑左子树
            }
            // 节点为空，就出栈
            this.cur = this.stack.pop();
            res = this.cur.val;
            // 考虑右子树
            this.cur = this.cur.right;
            break;
        }

        return res;
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return this.cur != null || !this.stack.isEmpty();
    }
}
