package stariq.algorithms.binarytree;

import stariq.datastructures.binarytree.TreeNode;

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

        TreeNode.print(root);
        System.out.println();
        TreeNode.print(deleteNode(root, 3));
    }

    public static TreeNode deleteNode(TreeNode root, int element) {
        if(root == null) {
            return null;
        }
        if(element < root.val) {
            root.left = deleteNode(root.left, element);
        } else if (element > root.val) {
            root.right = deleteNode(root.right, element);
        } else {
            if(root.left != null && root.right != null) {
                TreeNode temp = root;
                TreeNode minRight = minimumElement(temp.right);
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
