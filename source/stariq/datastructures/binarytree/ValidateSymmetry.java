package stariq.datastructures.binarytree;

import stariq.datastructures.nodes.TreeNode;

import java.util.*;

// https://leetcode.com/problems/symmetric-tree/
public class ValidateSymmetry {

    public static void main(String[] args) {
        TreeNode bst = new TreeNode(1);
        TreeNode root = bst;
        bst.left = new TreeNode(2);
        bst.left.left = null; // new TreeNode(4);
        bst.left.right = new TreeNode(3);
        bst.right = new TreeNode(2);
        bst.right.left = null; // new TreeNode(4);
        bst.right.right = new TreeNode(3);
        System.out.println(isSymmetricIterative(root));
    }

    public static boolean isSymmetricIterative(TreeNode root) {
        if(root == null) {
            return true;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root.left);
        queue.add(root.right);
        while(!queue.isEmpty()) {
            TreeNode left = queue.poll();
            TreeNode right = queue.poll();
            if(left == null && right == null) {
                continue;
            }
            if(left == null || right == null) {
                return false;
            }
            if(left.val != right.val) {
                return false;
            }
            queue.add(left.left);
            queue.add(right.right);
            queue.add(left.right);
            queue.add(right.left);
        }
        return true;
    }

    public boolean isSymmetricRecursive(TreeNode root) {
        if(root == null) {
            return true;
        }
        return isSymmetric(root.left, root.right);
    }

    private static boolean isSymmetric(TreeNode left, TreeNode right) {
        if(left == null && right == null) {
            return true;
        }
        if(left == null || right == null) {
            return false;
        }
        if(left.val != right.val) {
            return false;
        }
        return isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
    }
}
