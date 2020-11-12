package stariq.datastructures;

// Creates binary tree.
// Adds element(s) to the binary tree.
// Searches for element(s) in the binary tree.

import stariq.older.BinaryTree;

public class OldBinaryTreeTest {

    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.addElement(2);
        System.out.println("Value of an element: " + binaryTree.getRootElement());
        int[] seq = {3,4,5};
        binaryTree.addElements(seq);
        System.out.println("Value of elements: " + binaryTree.getRightChild(binaryTree.getRootElement()));
    }
}


