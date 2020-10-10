package stariq.algorithms.binarytree;

import stariq.datastructures.binarytree.TreeNode;

import java.util.ArrayList;
import java.util.List;

// root -> left -> right
// Preorder traversal of binary tree
// Goes to root node, then goes to left node, then goes to right node.
public class PreorderTraversal {

    public static void main(String[] args) {
        TreeNode bst = new TreeNode(5);
        TreeNode root = bst;
        bst.left = new TreeNode(3);
        bst.left.left = new TreeNode(1);
        bst.left.right = new TreeNode(4);
        bst.right = new TreeNode(8);
        bst.right.left = new TreeNode(7);
        bst.right.right = new TreeNode(9);

        for(int i : preorderTraversal(root)) {
            System.out.print(i + " ");
        }
    }

    public static List<Integer> preorderTraversal(TreeNode root) {
        return new ArrayList<>();
    }

}
