package com.stariq;

public interface IBinaryTree {

    int getRootElement();

    int getNumberOfElements();

    void addElement(int element);

    void addElements(int[] elements);

    int getLeftChild(int element);

    int getRightChild(int element);

}