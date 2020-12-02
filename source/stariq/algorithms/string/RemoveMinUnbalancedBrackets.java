package stariq.algorithms.string;

import java.util.Stack;

// https://leetcode.com/problems/minimum-remove-to-make-valid-parentheses/
public class RemoveMinUnbalancedBrackets {

    public static void main(String[] args) {
        System.out.println(minRemove("lee(t(c)o)de)"));
    }

    public static String minRemove(String str) {
        StringBuilder sb = new StringBuilder(str);
        // Stack contains indices of open brackets.
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < sb.length(); i++) {
            char c = sb.charAt(i);
            if(c == '(') {
                stack.add(i);
            }
            if(c == ')') {
                if(!stack.isEmpty()) {
                    stack.pop();
                } else {
                    sb.setCharAt(i, '*');
                }
            }
        }
        while(!stack.isEmpty()) {
            sb.setCharAt(stack.pop(), '*');
        }
        return sb.toString().replace("*", "");
    }
}
