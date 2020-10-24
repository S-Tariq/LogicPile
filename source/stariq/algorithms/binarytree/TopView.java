package stariq.algorithms.binarytree;

import stariq.datastructures.binarytree.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.TreeMap;

public class TopView {

    public static void main(String[] args) {
        TreeNode bst = new TreeNode(5);
        TreeNode root = bst;
        bst.left = new TreeNode(3);
        bst.left.left = new TreeNode(1);
        bst.left.right = new TreeNode(4);
        bst.right = new TreeNode(8);
        bst.right.left = new TreeNode(7);
        bst.right.right = new TreeNode(9);

        topView(root);
    }

    public static void topView(TreeNode root) {
        Queue<QueueNode> queue = new LinkedList<>();
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        queue.add(new QueueNode(root, 0));

        while(!queue.isEmpty()) {
            QueueNode temp = queue.poll();
            if(!treeMap.containsKey(temp.position)) {
                treeMap.put(temp.position, temp.node.val);
            }
            if(temp.node.left != null) {
                 int pos = temp.position - 1;
                 queue.add(new QueueNode(temp.node.left, pos));
            }
            if(temp.node.right != null) {
                int pos = temp.position + 1;
                queue.add(new QueueNode(temp.node.right, pos));
            }
        }

        for(Integer i : treeMap.values()) {
            System.out.print(i + " ");
        }

    }

    static class QueueNode {
        TreeNode node;
        int position;

        QueueNode(TreeNode node, int position) {
            this.node = node;
            this.position = position;
        }
    }


}
