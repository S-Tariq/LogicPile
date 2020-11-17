package stariq.datastructures.binarytree;

import stariq.datastructures.nodes.TreeNode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

// https://leetcode.com/problems/diameter-of-binary-tree/
public class FindDiameter {

    public static void main(String[] args) {
        TreeNode bst = new TreeNode(5);
        TreeNode root = bst;
        bst.left = new TreeNode(3);
        bst.left.left = new TreeNode(1);
        bst.left.right = new TreeNode(4);
        bst.right = new TreeNode(8);
        bst.right.left = new TreeNode(7);
        bst.right.right = new TreeNode(9);
        System.out.println(diameterOfBinaryTree(root));
    }

    // Iterative
    public int diameterOfBT(TreeNode root) {
        Map<TreeNode, Integer> map = new HashMap<>();
        Stack<TreeNode> stack = new Stack<>();
        int diameter = 0;
        if(root != null) {
            stack.push(root);
        }

        while(!stack.isEmpty()) {
            TreeNode node = stack.peek();
            if(node.left != null && !map.containsKey(node.left)) {
                stack.push(node.left);
            } else if(node.right != null && !map.containsKey(node.right)) {
                stack.push(node.right);
            } else {
                stack.pop();
                int leftDepth = map.getOrDefault(node.left, 0);
                int rightDepth = map.getOrDefault(node.right, 0);
                map.put(node, 1 + Math.max(leftDepth, rightDepth));
                diameter = Math.max(diameter, leftDepth + rightDepth);
            }
        }
        return diameter;
    }

    // Recursive
    static int max;
    public static int diameterOfBinaryTree(TreeNode root) {
        max = 0;
        maxDepth(root);
        return max;
    }

    private static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = maxDepth(root.left);
        int right = maxDepth(root.right);

        max = Math.max(max, left + right);
        return Math.max(left, right) + 1;
    }
}
