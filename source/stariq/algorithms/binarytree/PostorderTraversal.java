package stariq.algorithms.binarytree;

import stariq.datastructures.binarytree.TreeNode;

import java.util.ArrayList;
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

        for(int i : postorderOneStack(root)) {
            System.out.print(i + " ");
        }
        System.out.println();
        for(int i : postorderTwoStacks(root)) {
            System.out.print(i + " ");
        }
        System.out.println();
        postorderRecursive(root);
    }

    public static List<Integer> postorderOneStack(TreeNode root) {
        List<Integer> bstList = new ArrayList<>();
        Stack<TreeNode> bstStack = new Stack<>();

        if(root == null) {
            return bstList;
        }

        bstStack.push(root);

        TreeNode previous = null;
        while(!bstStack.isEmpty()) {
            TreeNode current = bstStack.peek();

            // Goes down tree.
            if(previous == null || previous.left == current || previous.right == current) {
                if(current.left != null) {
                    bstStack.push(current.left);
                } else if (current.right != null) {
                    bstStack.push(current.right);
                } else {
                    bstStack.pop();
                    bstList.add(current.val);
                }

                // Goes up tree.
            } else if (current.left == previous) {
                if(current.right != null) {
                    bstStack.push(current.right);
                } else {
                    bstStack.pop();
                    bstList.add(current.val);
                }
            } else if (current.right == previous) {
                bstStack.pop();
                bstList.add(current.val);
            }
            previous = current;
        }
        return bstList;
    }

    public static List<Integer> postorderTwoStacks(TreeNode root) {
        List<Integer> bstList = new ArrayList<>();
        Stack<TreeNode> bstStack1 = new Stack<>();
        bstStack1.push(root);
        Stack<TreeNode> bstStack2 = new Stack<>();

        while(!bstStack1.isEmpty()) {
            TreeNode current = bstStack1.pop();
            bstStack2.push(current);

            if(current.left != null) {
                bstStack1.push(current.left);
            }
            if(current.right != null) {
                bstStack1.push(current.right);
            }
        }

        while(!bstStack2.isEmpty()) {
            TreeNode temp = bstStack2.pop();
            bstList.add(temp.val);
        }

        return bstList;
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
