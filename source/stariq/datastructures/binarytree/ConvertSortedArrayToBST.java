package stariq.datastructures.binarytree;

import stariq.datastructures.nodes.TreeNode;

import java.util.Stack;

// https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
public class ConvertSortedArrayToBST {

    public static void main(String[] args) {
        int[] array = new int[] {-10,-3,0,5,9};
        TreeNode.print(sortedArrayToBST(array));
        System.out.println();
        TreeNode.print(constructTreeFromArray(array));
    }

    // DFS
    public static TreeNode sortedArrayToBST(int[] array) {
        if(array.length == 0) {
            return null;
        }
        return constructTreeFromArray(array, 0, array.length - 1);
    }

    // DFS
    public static TreeNode constructTreeFromArray(int[] array, int low, int high) {
        if(low > high) {
            return null;
        }
        int mid = (low + high)/2;
        TreeNode root = new TreeNode(array[mid]);
        root.left = constructTreeFromArray(array, low, mid - 1);
        root.right = constructTreeFromArray(array, mid + 1, high);
        return root;
    }

    // BFS
    public static TreeNode constructTreeFromArray(int[] array) {
        class Node {
            TreeNode node;
            int low;
            int high;

            Node(TreeNode node, int low, int high) {
                this.node = node;
                this.low = low;
                this.high = high;
            }
        }

        if(array.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(0);
        Stack<Node> stack = new Stack<>();
        stack.push(new Node(root, 0, array.length - 1));
        while(!stack.isEmpty()) {
            Node current = stack.pop();
            int mid = (current.low + current.high)/2;
            current.node.val = array[mid];
            if(current.low < mid) {
                int low = (current.low + mid - 1)/2;
                current.node.left = new TreeNode(array[low]);
                stack.push(new Node(current.node.left, current.low, mid - 1));
            }
            if(current.high > mid) {
                int high = (mid + 1 + current.high)/2;
                current.node.right = new TreeNode(array[high]);
                stack.push(new Node(current.node.right, mid + 1, current.high));
            }
        }
        return root;
    }

    // BFS - longer version
    public static TreeNode constructTreeFromArray2(int[] nums) {
        class Node {
            TreeNode node;
            int low;
            int high;
            public Node(TreeNode node, int low, int high) {
                this.node = node;
                this.low = low;
                this.high = high;
            }
        }
        if (nums == null || nums.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(0);
        Stack<Node> stack = new Stack<>();
        Node node = new Node(root, 0, nums.length - 1);
        stack.push(node);
        while (!stack.isEmpty()) {
            Node current = stack.pop();
            int mid = current.low + (current.high - current.low) / 2;
            current.node.val = nums[mid];
            if (current.low < mid) {
                current.node.left = new TreeNode(nums[current.low +(mid-1-current.low)/2]);
                stack.push(new Node(current.node.left, current.low, mid - 1));
            }
            if (current.high > mid) {
                current.node.right = new TreeNode(nums[mid+1+(current.high -mid-1)/2]);
                stack.push(new Node(current.node.right, mid + 1, current.high));
            }
        }
        return root;
    }
}
