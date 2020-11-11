package stariq.algorithms.binarytree;

import stariq.datastructures.nodes.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

// https://leetcode.com/problems/invert-binary-tree/
public class InvertBinaryTree {
    public static void main(String[] args) {
        TreeNode bst = new TreeNode(5);
        TreeNode root = bst;
        bst.left = new TreeNode(3);
        bst.left.left = new TreeNode(1);
        bst.left.right = new TreeNode(4);
        bst.right = new TreeNode(8);
        bst.right.left = new TreeNode(7);
        bst.right.right = new TreeNode(9);

        TreeNode.print(invertTreeIterative(root));
    }

    // BFS - LevelOrderTraversal.
    public static TreeNode invertTreeIterative(TreeNode root) {
        if(root == null) {
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()) {
            TreeNode current = queue.poll();
            TreeNode left = current.left;
            current.left = current.right;
            current.right = left;

            if(current.left != null) {
                queue.add(current.left);
            }
            if(current.right != null) {
                queue.add(current.right);
            }
        }
        return root;
    }

    // DFS.
    public static TreeNode invertTreeRecursion(TreeNode root) {
        if(root == null) {
            return null;
        }
        TreeNode left = root.left;
        TreeNode right = root.right;
        root.left = invertTreeRecursion(right);
        root.right = invertTreeRecursion(left);
        return root;
    }
}
