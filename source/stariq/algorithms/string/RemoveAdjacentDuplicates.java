package stariq.algorithms.string;

import java.util.Stack;

// https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string/
public class RemoveAdjacentDuplicates {

    public static void main(String[] args) {
        System.out.println(removeDuplicates("abbaca"));
        System.out.println(removeDuplicatesStack("abbaca"));
    }

    public static String removeDuplicates(String str) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < str.length(); i++) {
            char strChar = str.charAt(i);
            int sbLastI = sb.length() - 1;
            if(sb.length() == 0 || sb.charAt(sbLastI) != strChar) {
                sb.append(strChar);
            } else {
                sb.deleteCharAt(sbLastI);
            }
        }
        return sb.toString();
    }

    public static String removeDuplicatesStack(String str) {
        Stack<Character> stack = new Stack<>();
        for(char c : str.toCharArray()) {
            if(stack.isEmpty() || stack.peek() != c) {
                stack.push(c);
            } else {
                stack.pop();
            }
        }
        StringBuilder sb = new StringBuilder();
        for(char c : stack) {
            sb.append(c);
        }
        return sb.toString();
    }

    // Works but not the best solution.
    public static String removeDuplicates2(String str) {
        StringBuilder sb = new StringBuilder(str);
        for(int i = 0; i < sb.length() - 1; i++) {
            char c = sb.charAt(i);
            char c2 = sb.charAt(i+1);
            if(c == c2) {
                sb.delete(i, i+2);
                i = -1;
            }
        }
        return sb.toString();
    }
}
