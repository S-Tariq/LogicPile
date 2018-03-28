package com.stariq;

import java.util.List;
import java.util.Stack;

public class BalancedBrackets {

    private static List<Character> openB = List.of('(', '[', '{');
    private static List<Character> closedB = List.of(')', ']', '}');

    public static boolean exec(String seq) {
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
