package com.stariq;

import java.util.Stack;

public class BracketsInput {

    public static boolean correctParenthensies(String symb) {
        Stack<Character> stack  = new Stack<Character>();
        for(int i = 0; i < symb.length(); i++) {
            char c = symb.charAt(i);
            if(c == '[' || c == '(' || c == '{' ) {
                stack.push(c);
            } else if(c == ']') {
                if(stack.isEmpty() || stack.pop() != '[') {
                    return false;
                }
            } else if(c == ')') {
                if(stack.isEmpty() || stack.pop() != '(') {
                    return false;
                }
            } else if(c == '}') {
                if(stack.isEmpty() || stack.pop() != '{') {
                    return false;
                }
            }

        }
        return stack.isEmpty();
    }

}
