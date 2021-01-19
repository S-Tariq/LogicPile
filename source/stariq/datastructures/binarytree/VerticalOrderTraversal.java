package stariq.datastructures.binarytree;

import stariq.datastructures.nodes.TreeNode;

import java.util.*;

// https://leetcode.com/problems/vertical-order-traversal-of-a-binary-tree/
public class VerticalOrderTraversal {

    public static void main(String[] args) {
        TreeNode bst = new TreeNode(5);
        TreeNode root = bst;
        bst.left = new TreeNode(3);
        bst.left.left = new TreeNode(1);
        bst.left.right = new TreeNode(4);
        bst.right = new TreeNode(8);
        bst.right.left = new TreeNode(7);
        bst.right.right = new TreeNode(9);
        for(List<Integer> i : verticalOrder(root)) {
            System.out.print(Arrays.toString(i.toArray()) + " ");
        }
    }

    public static List<List<Integer>> verticalOrder(TreeNode root) {

        class PosNode {
            TreeNode node;
            int position;

            PosNode(TreeNode node, int position) {
                this.node = node;
                this.position = position;
            }
        }

        List<List<Integer>> result = new ArrayList<>();
        if(root == null) {
            return result;
        }

        int min = 0;
        int max = 0;

        Map<Integer, List<Integer>> map = new HashMap<>();
        Queue<PosNode> queue = new LinkedList<>();
        queue.add(new PosNode(root, 0));

        while(!queue.isEmpty()){
            int size = queue.size();
            Map<Integer, List<Integer>> tempMap = new HashMap<>();
            for(int i = 0; i < size; i++){
                PosNode current = queue.poll();

                min = Math.min(min, current.position);
                max = Math.max(max, current.position);

                if(!tempMap.containsKey(current.position)) {
                    tempMap.put(current.position, new ArrayList<Integer>());
                }
                tempMap.get(current.position).add(current.node.val);

                if(current.node.left != null) {
                    int pos = current.position - 1;
                    queue.add(new PosNode(current.node.left, pos));
                }
                if(current.node.right!= null) {
                    int pos = current.position + 1;
                    queue.add(new PosNode(current.node.right, pos));
                }
            }
            for(Map.Entry<Integer, List<Integer>> e : tempMap.entrySet()){
                if(!map.containsKey(e.getKey())) {
                   map.put(e.getKey(), new ArrayList<>());
                }
                List<Integer> list = e.getValue();
                Collections.sort(list);
                map.get(e.getKey()).addAll(list);
            }

        }
        for (int i = min; i <= max; i++){
            result.add(map.get(i));
        }
        return result;
    }
}
