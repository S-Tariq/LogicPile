package stariq.algorithms;

import java.util.List;
import java.util.Stack;

public class BalancedBrackets {

    public static void main(String[] args) {
        addBrackets("{[]}");
        addBrackets("{}{]");
    }

    // To check validity
    public static void addBrackets(String s){
        boolean isValid = BalancedBrackets.isBalanced(s);
        if (isValid) {
            System.out.println("String is valid");
        } else {
            System.out.println("String is invalid");
        }
    }

    private static List<Character> openB = List.of('(', '[', '{');
    private static List<Character> closedB = List.of(')', ']', '}');

    public static boolean isBalanced(String seq) {
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
