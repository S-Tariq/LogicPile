package stariq.algorithms.binarytree;

import stariq.datastructures.binarytree.TreeNode;

public class FindNode {

    public static void main(String[] args) {
        TreeNode bst = new TreeNode(5);
        TreeNode root = bst;
        bst.left = new TreeNode(3);
        bst.left.left = new TreeNode(1);
        bst.left.right = new TreeNode(4);
        bst.right = new TreeNode(8);
        bst.right.left = new TreeNode(7);
        bst.right.right = new TreeNode(9);

        TreeNode.print(findNodeIterative(root, 3));

        TreeNode.print(findNodeRecursive(root, 4));
    }

    public static TreeNode findNodeIterative(TreeNode root, int element) {
        if(root == null) {
            return null;
        }
        TreeNode current = root;
        while(current != null) {
            if(element == current.val) {
                return current;
            } else if (element < current.val) {
                current = current.left;
            } else if (element > current.val) {
                current = current.right;
            }
        }
        return null;
    }

    public static TreeNode findNodeRecursive(TreeNode root, int element) {
        if(root == null) {
            return null;
        }
        if(element == root.val) {
            return root;
        } else if (element < root.val) {
            return findNodeRecursive(root.left, element);
        } else {
            return findNodeRecursive(root.right, element);
        }
    }
}
