package stariq.datastructures.binarytree;

import stariq.datastructures.nodes.TreeNode;

import java.util.*;

// https://leetcode.com/problems/binary-tree-level-order-traversal-ii/
public class LevelOrderTraversalBottomUp {

    public static void main(String[] args) {
        TreeNode bst = new TreeNode(5);
        TreeNode root = bst;
        bst.left = new TreeNode(3);
        bst.left.left = new TreeNode(1);
        bst.left.right = new TreeNode(4);
        bst.right = new TreeNode(8);
        bst.right.left = new TreeNode(7);
        bst.right.right = new TreeNode(9);

        for(List<Integer> i : levelOrderBottom(root)) {
            System.out.print(Arrays.toString(i.toArray()) + " ");
        }
    }

    public static List<List<Integer>> levelOrderBottom(TreeNode root) {
        LinkedList<List<Integer>> twoDList = new LinkedList<>();
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
            twoDList.addFirst(list);
        }
        return twoDList;

    }
}
