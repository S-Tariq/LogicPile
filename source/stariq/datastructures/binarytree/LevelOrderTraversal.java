package stariq.datastructures.binarytree;

import stariq.datastructures.nodes.TreeNode;

import java.util.*;

// https://leetcode.com/problems/binary-tree-level-order-traversal/
// Breadth first traversal (level order traversal) of a binary tree.
public class LevelOrderTraversal {

    public static void main(String[] args) {
        TreeNode bst = new TreeNode(5);
        TreeNode root = bst;
        bst.left = new TreeNode(3);
        bst.left.left = new TreeNode(1);
        bst.left.right = new TreeNode(4);
        bst.right = new TreeNode(8);
        bst.right.left = new TreeNode(7);
        bst.right.right = new TreeNode(9);

        for(int i : levelOrder(root)) {
            System.out.print(i + " ");
        }
        System.out.println();
        for(List<Integer> i : levelOrder2d(root)) {
            System.out.print(Arrays.toString(i.toArray()) + " ");
        }
    }

    public static List<List<Integer>> levelOrder2d(TreeNode root) {
        List<List<Integer>> twoDList = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();

        if(root == null) {
            return twoDList;
        }

        queue.add(root);
        while(!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            for(int i = 0; i < size; i++) {
                TreeNode current = queue.poll();
                list.add(current.val);
                if(current.left != null) {
                    queue.add(current.left);
                }
                if(current.right != null) {
                    queue.add(current.right);
                }
            }
            twoDList.add(list);
        }
        return twoDList;
    }

    public static List<Integer> levelOrder(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();

        if(root == null) {
            return list;
        }

        queue.add(root);
        while(!queue.isEmpty()) {
            TreeNode current = queue.poll();
            list.add(current.val);
            if(current.left != null) {
                queue.add(current.left);
            }
            if(current.right != null) {
                queue.add(current.right);
            }
        }
        return list;
    }
}
