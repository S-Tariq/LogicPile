package stariq.datastructures.binarytree;

import stariq.datastructures.nodes.TreeNode;

import java.util.LinkedList;
import java.util.Map;
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
        class PosNode {
            TreeNode node;
            int position;

            PosNode(TreeNode node, int position) {
                this.node = node;
                this.position = position;
            }
        }

        if(root == null) {
            return;
        }

        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        Queue<PosNode> queue = new LinkedList<>();

        queue.add(new PosNode(root, 0));

        while(!queue.isEmpty()) {
            PosNode current = queue.poll();
            if(!treeMap.containsKey(current.position)) {
                treeMap.put(current.position, current.node.val);
            }
            if(current.node.left != null) {
                 int pos = current.position - 1;
                 queue.add(new PosNode(current.node.left, pos));
            }
            if(current.node.right != null) {
                int pos = current.position + 1;
                queue.add(new PosNode(current.node.right, pos));
            }
        }

        for(Integer i : treeMap.values()) {
            System.out.print(i + " ");
        }

        // Different way
//        for(Map.Entry<Integer, Integer> e : treeMap.entrySet()) {
//            System.out.print(e.getValue() + " ");
//        }

    }

}
