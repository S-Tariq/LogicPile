package stariq.algorithms.binarytree;

import stariq.datastructures.binarytree.TreeNode;

public class FindDepth {

    public static void main(String[] args) {
        TreeNode bst = new TreeNode(5);
        TreeNode root = bst;
        bst.left = new TreeNode(3);
        bst.left.left = new TreeNode(1);
        bst.left.right = new TreeNode(4);
        bst.right = new TreeNode(8);
        bst.right.left = new TreeNode(7);
        bst.right.right = new TreeNode(9);

        System.out.println(findDepth(root));
    }

    public static int findDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int left = findDepth(root.left);
        int right = findDepth(root.right);
        return Math.max(left, right) + 1;
    }


}
