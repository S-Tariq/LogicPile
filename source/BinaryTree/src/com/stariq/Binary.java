package com.stariq;

public class Binary implements IBinaryTree {

    private Node root;
    private int numberOfElements;

    public int getRootElement() {
        return root.getKey();
    }

    public int getNumberOfElements() {
        return numberOfElements;
    }

    public void addElement(int element) {
        if (root == null) {
            root = new Node(element);
            numberOfElements++;
        } else {
            Node focusNode = root;
            boolean nodeSet = false;
            while (!nodeSet) {
                if (element < focusNode.getKey()) {
                    if (focusNode.getLeft() == null){
                        focusNode.setLeft(new Node(element));
                        nodeSet = true;
                        numberOfElements++;
                    } else {
                        focusNode = focusNode.getLeft();
                    }
                }else if (element > focusNode.getKey()) {
                    if (focusNode.getRight() == null){
                        focusNode.setRight(new Node(element));
                        nodeSet = true;
                        numberOfElements++;
                    } else {
                        focusNode = focusNode.getRight();
                    }
                }
            }
        }
    }

    public void addElements(int[] elements) {
        for (int i = 0; i < elements.length; i++) {
            addElement(elements[i]);
        }
    }

    private Node getNode(int element) {

        Node focusNode = root;
        while (focusNode != null) {
            if (focusNode.getKey() == element) {
                return focusNode;
            } else {
                if (focusNode.getKey() > element) {
                    focusNode = focusNode.getRight();
                } else {
                    focusNode = focusNode.getLeft();
                }
            }
        }
        return null;
    }

    public int getLeftChild(int element) {
        Node node = getNode(element);
        if (node != null){
            return node.getLeft().getKey();
        }
        return -1;
    }
    public int getRightChild(int element) {

        Node node = getNode(element);
        if (node != null){
            return node.getRight().getKey();
        }
        return -1;
    }

}

