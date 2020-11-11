package stariq.algorithms.binarytree;

import stariq.datastructures.nodes.TreeNode;

// https://leetcode.com/problems/diameter-of-binary-tree/
public class FindDiameter {

    public static void main(String[] args) {
        TreeNode bst = new TreeNode(5);
        TreeNode root = bst;
        bst.left = new TreeNode(3);
        bst.left.left = new TreeNode(1);
        bst.left.right = new TreeNode(4);
        bst.right = new TreeNode(8);
        bst.right.left = new TreeNode(7);
        bst.right.right = new TreeNode(9);
        System.out.println(diameterOfBinaryTree(root));
    }

    static int max = 0;
    public static int diameterOfBinaryTree(TreeNode root) {
        maxDepth(root);
        return max;
    }

    private static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = maxDepth(root.left);
        int right = maxDepth(root.right);

        max = Math.max(max, left + right);
        return Math.max(left, right) + 1;
    }
}
