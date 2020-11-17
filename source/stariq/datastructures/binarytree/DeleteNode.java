package stariq.datastructures.binarytree;

import stariq.datastructures.nodes.TreeNode;

// https://leetcode.com/problems/delete-node-in-a-bst/
// If the node to be deleted has two kids: either do maximum left or minimum right.
public class DeleteNode {

    public static void main(String[] args) {
        TreeNode bst = new TreeNode(5);
        TreeNode root = bst;
        bst.left = new TreeNode(3);
        bst.left.left = new TreeNode(1);
        bst.left.right = new TreeNode(4);
        bst.right = new TreeNode(8);
        bst.right.left = new TreeNode(7);
        bst.right.right = new TreeNode(9);
        bst.right.right.right = new TreeNode(10);

        TreeNode.print(root);
        System.out.println();
    //    TreeNode.print(deleteNode(root, 3));
        System.out.println();
        TreeNode.print(deleteNode(root, 9));
    }

    public static TreeNode deleteNode(TreeNode root, int val) {
        if(root == null) {
            return null;
        }
        if(root.val > val) {
            root.left = deleteNode(root.left, val);
        } else if (root.val < val) {
            root.right = deleteNode(root.right, val);
        } else {
            if(root.left != null && root.right != null) {
                TreeNode minRight = minimumElement(root.right);
                root.val = minRight.val;
                root.right = deleteNode(root.right, minRight.val);
            } else if (root.left != null) {
                root = root.left;
            } else if (root.right != null) {
                root = root.right;
            } else {
                root = null;
            }
        }
        return root;
    }

    public static TreeNode minimumElement(TreeNode root) {
        if(root.left == null) {
            return root;
        }
        return minimumElement(root.left);
    }
}
