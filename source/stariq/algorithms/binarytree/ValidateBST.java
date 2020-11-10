package stariq.algorithms.binarytree;

import stariq.datastructures.nodes.TreeNode;

import java.util.Stack;

// https://leetcode.com/problems/validate-binary-search-tree/
public class ValidateBST {
    public static void main(String[] args) {
        TreeNode bst = new TreeNode(5);
        TreeNode root = bst;
        bst.left = new TreeNode(3);
        bst.left.left = new TreeNode(1);
        bst.left.right = new TreeNode(6);
        bst.right = new TreeNode(8);
        bst.right.left = new TreeNode(7);
        bst.right.right = new TreeNode(9);

        System.out.println(isValidBST(root));
    }

    public static boolean isValidBST(TreeNode root) {
        if(root == null) {
            return true;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode previous = null;
        TreeNode current = root;
        while(current != null || !stack.isEmpty()) {
            while(current != null) {
                stack.push(current);
                current = current.left;
            }
            current = stack.pop();
            if(previous != null && current.val <= previous.val) {
                return false;
            }
            previous = current;
            current = current.right;
        }
        return true;
    }
}
