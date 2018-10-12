package datastructures;

class BinaryNode {

    private int key;
    private BinaryNode left;
    private BinaryNode right;

    public BinaryNode(int key) {
        this.key = key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public int getKey() {
        return key;
    }

    public void setLeft(BinaryNode left) {
        this.left = left;
    }

    public BinaryNode getLeft() {
        return left;
    }

    public void setRight(BinaryNode right) {
        this.right = right;
    }

    public BinaryNode getRight() {
        return right;
    }
}

public class BinaryTree {

    private BinaryNode root;
    private int numberOfElements;

    public int getRootElement() {
        return root.getKey();
    }

    public int getNumberOfElements() {
        return numberOfElements;
    }

    public void addElement(int element) {
        if (root == null) {
            root = new BinaryNode(element);
            numberOfElements++;
        } else {
            BinaryNode focusNode = root;
            boolean nodeSet = false;
            while (!nodeSet) {
                if (element < focusNode.getKey()) {
                    if (focusNode.getLeft() == null){
                        focusNode.setLeft(new BinaryNode(element));
                        nodeSet = true;
                        numberOfElements++;
                    } else {
                        focusNode = focusNode.getLeft();
                    }
                }else if (element > focusNode.getKey()) {
                    if (focusNode.getRight() == null){
                        focusNode.setRight(new BinaryNode(element));
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

    private BinaryNode getNode(int element) {

        BinaryNode focusNode = root;
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
        BinaryNode node = getNode(element);
        if (node != null){
            return node.getLeft().getKey();
        }
        return -1;
    }
    public int getRightChild(int element) {

        BinaryNode node = getNode(element);
        if (node != null){
            return node.getRight().getKey();
        }
        return -1;
    }

}

