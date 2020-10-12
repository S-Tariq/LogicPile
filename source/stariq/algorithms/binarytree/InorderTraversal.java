package stariq.algorithms.binarytree;

import stariq.datastructures.binarytree.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

// left -> root -> right
// Inorder traversal of binary tree - smallest to largest value.
// Goes to left node, then goes root node, then goes to right node.
// Everything on the left of the parent is less than parent value.
// Everything on the right of the parent is greater than parent value.
public class InorderTraversal {

    public static void main(String[] args) {
        TreeNode bst = new TreeNode(5);
        TreeNode root = bst;
        bst.left = new TreeNode(3);
        bst.left.left = new TreeNode(1);
        bst.left.right = new TreeNode(4);
        bst.right = new TreeNode(8);
        bst.right.left = new TreeNode(7);
        bst.right.right = new TreeNode(9);

        for(int i : inorderIterative(root)) {
            System.out.print(i + " ");
        }
        System.out.println();
        inorderRecursive(root);
    }

    public static List<Integer> inorderIterative(TreeNode root) {
        List<Integer> bstList = new ArrayList<>();
        Stack<TreeNode> bstStack = new Stack<>();

        if(root == null) {
            return bstList;
        }

        TreeNode current = root;
        while(current != null || !bstStack.empty()) {
            while(current != null) {
                bstStack.push(current);
                current = current.left;
            }
            current = bstStack.pop();
            bstList.add(current.val);
            current = current.right;
        }
        return bstList;
    }

    // Cannot use list unless made static as recursion will keep recreating the same list.
    public static void inorderRecursive(TreeNode root) {
        if(root == null) {
            return;
        }
        inorderRecursive(root.left);
        System.out.print(root.val + " ");
        inorderRecursive(root.right);
    }
}
