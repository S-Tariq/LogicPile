package stariq.datastructures.binarytree;

import stariq.datastructures.nodes.TreeNode;

import java.util.Stack;

// https://leetcode.com/problems/flatten-binary-tree-to-linked-list/
public class FlattenTreeToLinkedList {
    public static void main(String[] args) {
        TreeNode bst = new TreeNode(1);
        TreeNode root = bst;
        bst.left = new TreeNode(2);
        bst.left.left = new TreeNode(3);
        bst.left.right = new TreeNode(4);
        bst.right = new TreeNode(5);
        bst.right.left = new TreeNode(6);
        flatten(root);
    }

    public static void flatten(TreeNode root) {
        if(root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()) {
            TreeNode current = stack.pop();
            if(current.right != null) {
                stack.push(current.right);
            }
            if(current.left != null) {
                stack.push(current.left);
            }
            if(!stack.isEmpty()) {
                current.right = stack.peek();
            }
            current.left = null;
        }
    }
}
