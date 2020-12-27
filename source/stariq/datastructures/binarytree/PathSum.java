package stariq.datastructures.binarytree;

import stariq.datastructures.nodes.TreeNode;
import java.util.Stack;

// https://leetcode.com/problems/path-sum/
// Root to leaf path sum.
public class PathSum {

    public static void main(String[] args) {
        TreeNode bst = new TreeNode(5);
        TreeNode root = bst;
        bst.left = new TreeNode(3);
        bst.left.left = new TreeNode(1);
        bst.left.right = new TreeNode(4);
        bst.right = new TreeNode(8);
        bst.right.left = new TreeNode(7);
        bst.right.right = new TreeNode(9);
        System.out.println(hasPathSumIterative(root, 20));
        System.out.println(hasPathSumRecursive(root, 20));
    }

    public static boolean hasPathSumIterative(TreeNode root, int sum) {
        if(root == null) {
            return false;
        }
        Stack<TreeNode> pathStack = new Stack<>();
        Stack<Integer> sumStack = new Stack<>();
        pathStack.push(root);
        sumStack.push(root.val);
        while(!pathStack.isEmpty()) {
            TreeNode current = pathStack.pop();
            int total = sumStack.pop();

            if(current.left == null && current.right == null && total == sum) {
                return true;
            }
            if(current.left != null) {
                pathStack.push(current.left);
                sumStack.push(total + current.left.val);
            }
            if(current.right != null) {
                pathStack.push(current.right);
                sumStack.push(total + current.right.val);

            }
        }
        return false;
    }

    public static boolean hasPathSumRecursive(TreeNode root, int sum) {
        if(root == null) {
            return false;
        }
        if(root.left == null && root.right == null && root.val == sum) {
            return true;
        }
        return hasPathSumRecursive(root.left, sum - root.val) || hasPathSumRecursive(root.right, sum - root.val);
    }
}
