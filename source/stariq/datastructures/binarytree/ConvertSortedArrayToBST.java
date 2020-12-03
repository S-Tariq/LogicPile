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
    public static TreeNode sortedArrayToBST(int[] nums) {
        if(nums.length == 0) {
            return null;
        }
        return constructTreeFromArray(nums, 0, nums.length - 1);
    }

    // DFS
    public static TreeNode constructTreeFromArray(int[] nums, int left, int right) {
        if(left > right) {
            return null;
        }
        int mid = (left + right)/2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = constructTreeFromArray(nums, left, mid - 1);
        root.right = constructTreeFromArray(nums, mid + 1, right);
        return root;
    }

    // BFS
    public static TreeNode constructTreeFromArray(int[] nums) {
        class Node {
            TreeNode node;
            int left, right;
            public Node(TreeNode node, int left, int right) {
                this.node = node;
                this.left = left;
                this.right = right;
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
            int mid = current.left + (current.right - current.left) / 2;
            current.node.val = nums[mid];
            if (current.left < mid) {
                current.node.left = new TreeNode(nums[current.left+(mid-1-current.left)/2]);
                stack.push(new Node(current.node.left, current.left, mid - 1));
            }
            if (current.right > mid) {
                current.node.right = new TreeNode(nums[mid+1+(current.right-mid-1)/2]);
                stack.push(new Node(current.node.right, mid + 1, current.right));
            }
        }
        return root;
    }
}
