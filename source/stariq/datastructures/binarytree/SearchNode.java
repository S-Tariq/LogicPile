package stariq.datastructures.binarytree;

import stariq.datastructures.nodes.TreeNode;

// https://leetcode.com/problems/search-in-a-binary-search-tree/
public class SearchNode {

    public static void main(String[] args) {
        TreeNode bst = new TreeNode(5);
        TreeNode root = bst;
        bst.left = new TreeNode(3);
        bst.left.left = new TreeNode(1);
        bst.left.right = new TreeNode(4);
        bst.right = new TreeNode(8);
        bst.right.left = new TreeNode(7);
        bst.right.right = new TreeNode(9);

        TreeNode.print(searchNodeIterative(root, 3));

        TreeNode.print(searchNodeRecursive(root, 4));
    }

    public static TreeNode searchNodeIterative(TreeNode root, int val) {
        if(root == null) {
            return null;
        }
        TreeNode current = root;
        while(current != null) {
            if(current.val == val) {
                return current;
            } else if (current.val > val) {
                current = current.left;
            } else if (current.val < val) {
                current = current.right;
            }
        }
        return null;
    }

    public static TreeNode searchNodeRecursive(TreeNode root, int val) {
        if(root == null) {
            return null;
        }
        if(root.val == val) {
            return root;
        } else if (root.val > val) {
            return searchNodeRecursive(root.left, val);
        } else {
            return searchNodeRecursive(root.right, val);
        }
    }
}
