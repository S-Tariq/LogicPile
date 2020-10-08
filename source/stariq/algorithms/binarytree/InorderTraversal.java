package stariq.algorithms.binarytree;

import stariq.datastructures.binarytree.BinarySearchTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

// left -> root -> right
// Inorder traversal of binary tree - smallest to largest value.
// Goes to left node, then goes root node, then goes to right node.
// Everything on the left of the parent is less than parent value.
// Everything on the right of the parent is greater than parent value.
public class InorderTraversal {

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree(5);
        BinarySearchTree root = bst;
        bst.left = new BinarySearchTree(3);
        bst.left.left = new BinarySearchTree(1);
        bst.left.right = new BinarySearchTree(4);
        bst.right = new BinarySearchTree(8);
        bst.right.left = new BinarySearchTree(7);
        bst.right.right = new BinarySearchTree(9);

        for(int i : inorderTraversal(root)) {
            System.out.print(i + " ");
        }
    }

    public static List<Integer> inorderTraversal(BinarySearchTree root) {
        Stack<BinarySearchTree> bstStack = new Stack<>();
        List<Integer> bstList = new ArrayList<>();

        if(root == null) {
            return bstList;
        }

        BinarySearchTree current = root;
        while(current != null || !bstStack.empty()) {
            while(current != null) {
                bstStack.push(current);
                current = current.left;
            }
            current = bstStack.pop();
            bstList.add(current.data);
            current = current.right;
        }
        return bstList;
    }
}
