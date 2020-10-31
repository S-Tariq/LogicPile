package stariq.algorithms.doublylinkedlist;

import stariq.datastructures.nodes.MultiNode;
import java.util.Stack;

// https://leetcode.com/problems/flatten-a-multilevel-doubly-linked-list/
// Flatten the multilevel doubly linkedlist to one level doubly linkedlist.

public class FlattenMultilevel {

    public static MultiNode flatten(MultiNode head) {
        if(head == null) {
            return null;
        }

        Stack<MultiNode> stack = new Stack<>();
        stack.push(head);
        MultiNode parent = null;

        while(!stack.isEmpty()) {
            MultiNode current = stack.pop();
            if(parent != null) {
                parent.next = current;
                current.prev = parent;
                parent.child = null;
            }

            while(current.next != null && current.child == null) {
                current = current.next;
            }

            parent = current;
            if(current.child != null) {
                if(current.next != null) {
                    stack.push(current.next);
                }
                stack.push(current.child);
            }
        }
        return head;
    }
}


