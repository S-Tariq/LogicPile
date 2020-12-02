package stariq.algorithms.string;

import java.util.*;

// https://leetcode.com/problems/remove-invalid-parentheses/
// Remove unbalanced brackets and return all possible results.
public class RemoveUnbalancedBrackets {

    public static void main(String[] args) {
        System.out.println(removeUnbalanced("()())"));
        System.out.println(removeInvalidParentheses("(a)())()"));
        System.out.println(removeInvalidParentheses("le(t(c)o)d)"));
    }

    // All the needed methods for iteration. (BFS)
    public static List<String> removeInvalidParentheses(String str) {
        List<String> result = new ArrayList<>();
        Queue<String> queue = new LinkedList<>();
        Set<String> set = new HashSet<>();
        boolean found = false;

        queue.add(str);
        set.add(str);

        while(!queue.isEmpty()) {
            String current = queue.poll();

            if(isValid(current)) {
                found = true;
                result.add(current);
            }

            if(found) {
                continue;
            }

            for(int i = 0; i < current.length(); i++) {
                if(current.charAt(i) != '(' && current.charAt(i) != ')') {
                    continue;
                }
                String temp = current.substring(0, i) + current.substring(i + 1);
                if(!set.contains(temp)) {
                    queue.add(temp);
                    set.add(temp);
                }
            }
        }
        return result;
    }

    private static boolean isValid(String str) {
        int count = 0;
        for(int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == '(') {
                count++;
            }
            if(str.charAt(i) == ')' ) {
                count--;
            }
            if(count < 0) {
                return false;
            }
        }
        return count == 0;
    }

    // All the needed methods for recursion.
    public static List<String> removeUnbalanced(String str) {
        List<String> result = new ArrayList<>();
        int bracketsToRemove = countBracketsToRemove(str);
        balance(str, bracketsToRemove, result);
        return result;
    }

    public static void balance(String str, int bracketsToRemove, List<String> result) {
        if(bracketsToRemove == 0) {
            // Checking if it is balanced - if it is then it returns 0.
            if(countBracketsToRemove(str) == 0) {
                if(!result.contains(str)) {
                    result.add(str);
                }
            }
        }

        for(int i = 0; i < str.length(); i++) {
            String left = str.substring(0, i);
            String right = str.substring(i + 1);
            balance(left + right, bracketsToRemove - 1, result);
        }
    }

    private static int countBracketsToRemove(String str) {
        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if(c == '(') {
                stack.push(c);
            } else if (c == ')') {
                if(stack.size() == 0) {
                    stack.push(c);
                } else if (stack.peek() == ')') {
                    stack.push(c);
                } else {
                    stack.pop();
                }
            }
        }
        return stack.size();
    }
}
