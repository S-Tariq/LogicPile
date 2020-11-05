package stariq.algorithms.string;

import java.util.List;
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
            if (openB.contains(c)) {
                seqStack.push(c);
            } else if (!seqStack.empty()) {
                int openBIdx = openB.indexOf(seqStack.pop());
                int closedBIdx = closedB.indexOf(c);
                if (openBIdx != closedBIdx) {
                    return false;
                }
            } else {
                return false;
            }
        }
        return seqStack.empty();
    }
}
