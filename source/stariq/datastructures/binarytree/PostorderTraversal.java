package stariq.datastructures.binarytree;

import stariq.datastructures.nodes.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

// left -> right -> root
// Postorder traversal of binary tree
// Goes to left node, then goes to right node, then goes to root node.
public class PostorderTraversal {

    public static void main(String[] args) {
        TreeNode bst = new TreeNode(5);
        TreeNode root = bst;
        bst.left = new TreeNode(3);
        bst.left.left = new TreeNode(1);
        bst.left.right = new TreeNode(4);
        bst.right = new TreeNode(8);
        bst.right.left = new TreeNode(7);
        bst.right.right = new TreeNode(9);

        for(int i : postorderIterative(root)) {
            System.out.print(i + " ");
        }
//        System.out.println();
//        for(int i : postorderTwoStacks(root)) {
//            System.out.print(i + " ");
//        }
        System.out.println();
        postorderRecursive(root);
    }

    public static List<Integer> postorderIterative(TreeNode root) {
        LinkedList<Integer> list = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();

        if (root == null) {
            return list;
        }

        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode current = stack.pop();
            list.addFirst(current.val);
            if (current.left != null) {
                stack.push(current.left);
            }
            if (current.right != null) {
                stack.push(current.right);
            }
        }
        return list;
    }

    // Works but very long
    public static List<Integer> postorderOneStack(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        if(root == null) {
            return list;
        }

        stack.push(root);

        TreeNode previous = null;
        while(!stack.isEmpty()) {
            TreeNode current = stack.peek();

            // Goes down tree.
            if(previous == null || previous.left == current || previous.right == current) {
                if(current.left != null) {
                    stack.push(current.left);
                } else if (current.right != null) {
                    stack.push(current.right);
                } else {
                    stack.pop();
                    list.add(current.val);
                }

                // Goes up tree.
            } else if (current.left == previous) {
                if(current.right != null) {
                    stack.push(current.right);
                } else {
                    stack.pop();
                    list.add(current.val);
                }
            } else if (current.right == previous) {
                stack.pop();
                list.add(current.val);
            }
            previous = current;
        }
        return list;
    }

    // Does not run on leetcode for some reason - gives null pointer exception - look into this!
    public static List<Integer> postorderTwoStacks(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack1 = new Stack<>();
        stack1.push(root);
        Stack<TreeNode> stack2 = new Stack<>();

        while(!stack1.isEmpty()) {
            TreeNode current = stack1.pop();
            stack2.push(current);

            if(current.left != null) {
                stack1.push(current.left);
            }
            if(current.right != null) {
                stack1.push(current.right);
            }
        }

        while(!stack2.isEmpty()) {
            TreeNode temp = stack2.pop();
            list.add(temp.val);
        }

        return list;
    }

    public static void postorderRecursive(TreeNode root) {
        if(root == null) {
            return;
        }
        postorderRecursive(root.left);
        postorderRecursive(root.right);
        System.out.print(root.val + " ");
    }


}
