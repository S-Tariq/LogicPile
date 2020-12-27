package stariq.datastructures.binarytree;

import stariq.datastructures.nodes.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

// https://leetcode.com/problems/maximum-depth-of-binary-tree/
// Depth is the longest path from the root to the farthest leaf node.
public class FindDepth {

    public static void main(String[] args) {
        TreeNode bst = new TreeNode(5);
        TreeNode root = bst;
        bst.left = new TreeNode(3);
        bst.left.left = new TreeNode(1);
        bst.left.right = new TreeNode(4);
        bst.right = new TreeNode(8);
        bst.right.left = new TreeNode(7);
        bst.right.right = new TreeNode(9);
        bst.right.right.right = new TreeNode(10);

        System.out.println(findDepth(root));
    }

    // Iterative
    public int maxDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int depth = 0;
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i = 0; i < size; i++) {
                TreeNode current = q.poll();
                if(current.left != null) {
                    q.add(current.left);
                }
                if(current.right != null) {
                    q.add(current.right);
                }
            }
            depth++;
        }
        return depth;
    }

    // Recursive
    public static int findDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int left = findDepth(root.left);
        int right = findDepth(root.right);
        return Math.max(left, right) + 1;
    }
}
