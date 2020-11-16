package stariq.datastructures.binarytree;

import stariq.datastructures.nodes.TreeNode;

import java.util.Stack;

public class KthLargestInBST {

    public static void main(String[] args) {
        TreeNode bst = new TreeNode(5);
        TreeNode root = bst;
        bst.left = new TreeNode(3);
        bst.left.left = new TreeNode(1);
        bst.left.right = new TreeNode(4);
        bst.right = new TreeNode(8);
        bst.right.left = new TreeNode(7);
        bst.right.right = new TreeNode(9);
        System.out.println(secondLargest(root, 2));
    }

    public static int secondLargest(TreeNode root, int k) {
        if(root == null) {
            return -1;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        int count = 0;
        while(current != null || !stack.isEmpty()) {
            while(current != null) {
                stack.push(current);
                current = current.right;
            }
            current = stack.pop();
            count++;
            if(count == k) {
                break;
            }
            current = current.left;

        }
        return current.val;
    }
}
