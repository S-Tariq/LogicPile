package stariq.datastructures.binarytree;

import stariq.datastructures.nodes.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

// root -> left -> right
// Preorder traversal of binary tree
// Goes to root node, then goes to left node, then goes to right node.
public class PreorderTraversal {

    public static void main(String[] args) {
        TreeNode bst = new TreeNode(5);
        TreeNode root = bst;
        bst.left = new TreeNode(3);
        bst.left.left = new TreeNode(1);
        bst.left.right = new TreeNode(4);
        bst.right = new TreeNode(8);
        bst.right.left = new TreeNode(7);
        bst.right.right = new TreeNode(9);

        for(int i : preorderIterative(root)) {
            System.out.print(i + " ");
        }
        System.out.println();
        preorderRecursive(root);
    }

    public static List<Integer> preorderIterative(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        if(root == null) {
            return list;
        }

        stack.push(root);

        while(!stack.isEmpty()) {
            TreeNode current = stack.pop();
            list.add(current.val);
            if(current.right != null) {
                stack.push(current.right);
            }
            if(current.left != null) {
                stack.push(current.left);
            }
        }
        return list;
    }

    // Cannot use list unless made static as recursion will keep recreating the same list.
    public static void preorderRecursive(TreeNode root) {
        if(root == null) {
            return;
        }
        System.out.print(root.val + " ");
        preorderRecursive(root.left);
        preorderRecursive(root.right);
    }

}
