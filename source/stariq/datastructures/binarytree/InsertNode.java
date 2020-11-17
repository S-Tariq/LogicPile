package stariq.datastructures.binarytree;

import stariq.datastructures.nodes.TreeNode;

// https://leetcode.com/problems/insert-into-a-binary-search-tree/
// Insert node in binary tree.
public class InsertNode {

    public static void main(String[] args) {
        TreeNode bst = new TreeNode(5);
        TreeNode root = bst;
        bst.left = new TreeNode(3);
        bst.left.left = new TreeNode(1);
        bst.left.right = new TreeNode(4);
        bst.right = new TreeNode(8);
        bst.right.left = new TreeNode(7);
        bst.right.right = new TreeNode(9);
        TreeNode.print(root);
        System.out.println();
        TreeNode.print(insertNodeIterative(root, 2));
        System.out.println();
        TreeNode.print(insertNodeRecursive(root, 6));
    }

    public static TreeNode insertNodeIterative(TreeNode root, int val) {
        if(root == null) {
            return new TreeNode(val);
        }
        TreeNode current = root;
        while(true) {
            if(current.val < val) {
                if(current.right != null) {
                    current = current.right;
                } else {
                    current.right = new TreeNode(val);
                    break;
                }
            } else if (current.val > val){
                if(current.left != null) {
                    current = current.left;
                } else {
                    current.left = new TreeNode(val);
                    break;
                }
            } else {
                // No duplicates allowed.
                break;
            }
        }
        return root;
    }

    public static TreeNode insertNodeRecursive(TreeNode root, int val) {
        if(root == null) {
            return new TreeNode(val);
        }
        if(root.val > val) {
            root.left = insertNodeRecursive(root.left,val);
        } else {
            root.right = insertNodeRecursive(root.right, val);
        }
        return root;
    }

}
