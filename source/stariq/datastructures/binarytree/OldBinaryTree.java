package stariq.datastructures.binarytree;

class OldBinaryNode {

    private int key;
    private OldBinaryNode left;
    private OldBinaryNode right;

    public OldBinaryNode(int key) {
        this.key = key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public int getKey() {
        return key;
    }

    public void setLeft(OldBinaryNode left) {
        this.left = left;
    }

    public OldBinaryNode getLeft() {
        return left;
    }

    public void setRight(OldBinaryNode right) {
        this.right = right;
    }

    public OldBinaryNode getRight() {
        return right;
    }
}

public class OldBinaryTree {

    private OldBinaryNode root;
    private int numberOfElements;

    public int getRootElement() {
        return root.getKey();
    }

    public int getNumberOfElements() {
        return numberOfElements;
    }

    public void addElement(int element) {
        if (root == null) {
            root = new OldBinaryNode(element);
            numberOfElements++;
        } else {
            OldBinaryNode focusNode = root;
            boolean nodeSet = false;
            while (!nodeSet) {
                if (element < focusNode.getKey()) {
                    if (focusNode.getLeft() == null){
                        focusNode.setLeft(new OldBinaryNode(element));
                        nodeSet = true;
                        numberOfElements++;
                    } else {
                        focusNode = focusNode.getLeft();
                    }
                }else if (element > focusNode.getKey()) {
                    if (focusNode.getRight() == null){
                        focusNode.setRight(new OldBinaryNode(element));
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

    private OldBinaryNode getNode(int element) {

        OldBinaryNode focusNode = root;
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
        OldBinaryNode node = getNode(element);
        if (node != null){
            return node.getLeft().getKey();
        }
        return -1;
    }
    public int getRightChild(int element) {

        OldBinaryNode node = getNode(element);
        if (node != null){
            return node.getRight().getKey();
        }
        return -1;
    }

}

