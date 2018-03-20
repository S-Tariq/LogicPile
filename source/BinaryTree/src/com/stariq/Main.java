package com.stariq;

// Creates binary tree.
// Adds element(s) to the binary tree.
// Searches for element(s) in the binary tree.

public class Main {

    public static void main(String[] args) {
        Binary binaryTree = new Binary();
        binaryTree.addElement(2);
        System.out.println("Value of an element: " + binaryTree.getRootElement());
        int[] seq = {3,4,5};
        binaryTree.addElements(seq);
        System.out.println("Value of elements: " + binaryTree.getRightChild(binaryTree.getRootElement()));
    }
}