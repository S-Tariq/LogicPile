package stariq.older;

public class BinaryTree {

    class BinaryNode {
        int key;
        BinaryNode left;
        BinaryNode right;

        public BinaryNode(int key) {
            this.key = key;
        }
    }

    private BinaryNode root;
    private int numberOfElements;

    public int getRootElement() {
        return root.key;
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
                if (element < focusNode.key) {
                    if (focusNode.left == null){
                        focusNode.left = new BinaryNode(element);
                        nodeSet = true;
                        numberOfElements++;
                    } else {
                        focusNode = focusNode.left;
                    }
                } else if (element > focusNode.key) {
                    if (focusNode.right == null){
                        focusNode.right = new BinaryNode(element);
                        nodeSet = true;
                        numberOfElements++;
                    } else {
                        focusNode = focusNode.right;
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
            if (focusNode.key == element) {
                return focusNode;
            } else {
                if (focusNode.key > element) {
                    focusNode = focusNode.right;
                } else {
                    focusNode = focusNode.left;
                }
            }
        }
        return null;
    }

    public int getLeftChild(int element) {
        BinaryNode node = getNode(element);
        if (node != null){
            return node.left.key;
        }
        return -1;
    }
    public int getRightChild(int element) {

        BinaryNode node = getNode(element);
        if (node != null){
            return node.right.key;
        }
        return -1;
    }
}

