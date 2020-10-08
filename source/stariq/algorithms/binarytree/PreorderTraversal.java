package stariq.algorithms.binarytree;

import stariq.datastructures.binarytree.BinarySearchTree;

import java.util.ArrayList;
import java.util.List;

// root -> left -> right
// Preorder traversal of binary tree
// Goes to root node, then goes to left node, then goes to right node.
public class PreorderTraversal {

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree(5);
        BinarySearchTree root = bst;
        bst.left = new BinarySearchTree(3);
        bst.left.left = new BinarySearchTree(1);
        bst.left.right = new BinarySearchTree(4);
        bst.right = new BinarySearchTree(8);
        bst.right.left = new BinarySearchTree(7);
        bst.right.right = new BinarySearchTree(9);

        for(int i : preorderTraversal(root)) {
            System.out.print(i + " ");
        }
    }

    public static List<Integer> preorderTraversal(BinarySearchTree root) {
        return new ArrayList<>();
    }

}
