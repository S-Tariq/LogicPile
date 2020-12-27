package stariq.algorithms.string;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

// https://leetcode.com/problems/valid-parentheses/
// Checks to see if a string has balanced brackets.
public class BalancedBrackets {

    public static void main(String[] args) {
        System.out.println(isBalanced("{[]}"));
        System.out.println(isBalanced("{}{]"));
    }

    public static boolean isBalanced(String seq) {
        List<Character> openB = List.of('(', '[', '{');
        List<Character> closedB = List.of(')', ']', '}');
        Stack<Character> seqStack = new Stack<>();
        for (char c : seq.toCharArray()) {
            // Open bracket.
            if (openB.contains(c)) {
                seqStack.push(c);
                // Closed bracket and stack not empty.
            } else if (!seqStack.empty()) {
                int openBIdx = openB.indexOf(seqStack.pop());
                int closedBIdx = closedB.indexOf(c);
                if (openBIdx != closedBIdx) {
                    return false;
                }
                // Closed bracket and stack is empty.
            } else {
                return false;
            }
        }
        return seqStack.empty();
    }

    public static boolean isBalanced2(String str) {
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']','[');
        map.put('}', '{');

        Stack<Character> stack = new Stack<>();
        for(char c : str.toCharArray()) {
            if(map.containsValue(c)) {
                stack.push(c);
            } else if(map.containsKey(c)) {
                if(stack.isEmpty() || map.get(c) != stack.pop()) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
