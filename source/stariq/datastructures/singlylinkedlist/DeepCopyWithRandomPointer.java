package stariq.datastructures.singlylinkedlist;

import stariq.datastructures.nodes.RandNode;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/copy-list-with-random-pointer/
// Shallow copy = reference
// Deep copy = data without reference
public class DeepCopyWithRandomPointer {

    public RandNode copyRandomList(RandNode head) {
        if(head == null) {
            return null;
        }
        Map<RandNode, RandNode> map = new HashMap<>();
        RandNode current = head;
        while(current != null) {
            map.put(current, new RandNode(current.val));
            current = current.next;
        }

        current = head;
        while(current != null) {
            RandNode node = map.get(current);
            node.next = map.get(current.next);
            node.random = map.get(current.random);
            current = current.next;
        }
        return map.get(head);
    }

    public RandNode copyRandomList2(RandNode head) {

        Map<RandNode,Integer> inputMap = new HashMap<>();
        Map<Integer, RandNode> resultMap = new HashMap<>();
        RandNode current = head;
        RandNode result = new RandNode(0);
        RandNode resultHead = result;
        int count = 0;
        while(current != null) {
            inputMap.put(current, count);
            result.next = new RandNode(current.val);
            resultMap.put(count, result.next);
            count++;
            current = current.next;
            result = result.next;
        }

        current = head;
        result = resultHead.next;
        while(current != null) {
            if(current.random != null) {
                Integer index = inputMap.get(current.random);
                result.random = resultMap.get(index);
            }
            current = current.next;
            result = result.next;
        }
        return resultHead.next;
    }
}
