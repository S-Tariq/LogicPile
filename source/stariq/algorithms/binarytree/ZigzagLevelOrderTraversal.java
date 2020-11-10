package stariq.algorithms.binarytree;

import stariq.datastructures.nodes.TreeNode;

import java.util.*;

// https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
public class ZigzagLevelOrderTraversal {

    public static void main(String[] args) {
        TreeNode bst = new TreeNode(5);
        TreeNode root = bst;
        bst.left = new TreeNode(3);
        bst.left.left = new TreeNode(1);
        bst.left.right = new TreeNode(4);
        bst.right = new TreeNode(8);
        bst.right.left = new TreeNode(7);
        bst.right.right = new TreeNode(9);

        for(int i : zigzagLevelOrderUsingStack(root)) {
            System.out.print(i + " ");
        }
        System.out.println();
        for(int i : zigzagLevelOrderUsingDeque(root)) {
            System.out.print(i + " ");
        }
        System.out.println();

        for(List<Integer> i : zigzagLevelOrder2d(root)) {
            System.out.print(Arrays.toString(i.toArray()) + " ");
        }

    }

    public static List<List<Integer>> zigzagLevelOrder2d(TreeNode root) {
        List<List<Integer>> twoDList = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();

        if(root == null) {
            return twoDList;
        }
        queue.add(root);
        boolean changeDirection = true;
        while(!queue.isEmpty()) {
            int size = queue.size();
            LinkedList<Integer> list = new LinkedList<>();
            for(int i = 0; i < size; i++) {
                TreeNode current = queue.poll();

                if(changeDirection) {
                    list.add(current.val);
                } else {
                    list.addFirst(current.val);
                }

                if(current.left != null) {
                    queue.add(current.left);
                }
                if(current.right != null) {
                    queue.add(current.right);
                }
            }
            twoDList.add(list);
            changeDirection = !changeDirection;
        }
        return twoDList;
    }

    public static List<Integer> zigzagLevelOrderUsingDeque(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Deque<TreeNode> currentQueue = new LinkedList<>();
        Deque<TreeNode> nextQueue = new LinkedList<>();

        if(root == null) {
            return list;
        }

        currentQueue.add(root);
        boolean changeDirection = false;

        while(!currentQueue.isEmpty()) {
            TreeNode current = currentQueue.poll();
            list.add(current.val);
            if(changeDirection) {
                if(current.right != null) {
                    nextQueue.addFirst(current.right);
                }
                if(current.left != null) {
                    nextQueue.addFirst(current.left);
                }
            } else {
                if(current.left != null) {
                    nextQueue.addFirst(current.left);
                }
                if(current.right != null) {
                    nextQueue.addFirst(current.right);
                }
            }
            if(currentQueue.isEmpty()) {
                changeDirection = !changeDirection;
                Deque<TreeNode> temp = currentQueue;
                currentQueue = nextQueue;
                nextQueue = temp;
            }
        }
        return list;
    }

    public static List<Integer> zigzagLevelOrderUsingStack(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> currentStack = new Stack<>();
        Stack<TreeNode> nextStack = new Stack<>();


        if(root == null) {
            return list;
        }
        currentStack.push(root);
        boolean changeDirection = true;

        while (!currentStack.isEmpty()) {
            TreeNode current = currentStack.pop();
            list.add(current.val);

            if (changeDirection) {
                if (current.left != null) {
                    nextStack.push(current.left);
                }
                if (current.right != null) {
                    nextStack.push(current.right);
                }
            }
            else {
                if (current.right != null) {
                    nextStack.push(current.right);
                }

                if (current.left != null) {
                    nextStack.push(current.left);
                }
            }

            if (currentStack.isEmpty()) {
                changeDirection = !changeDirection;
                Stack<TreeNode> temp = currentStack;
                currentStack = nextStack;
                nextStack = temp;
            }
        }
        return list;
    }

}
