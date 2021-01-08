package stariq.algorithms.string;

import java.util.Stack;

// Similar to RemoveAdjacentDuplicates2 but you remove k or more duplicates.
public class RemoveKOrMoreAdjacentDuplicates {

    public static void main(String[] args) {
        System.out.println(removeDuplicates("iiiixxxxxiiccccczzffffflllllllllfffffllyyyyyuuuuuz", 3));
        System.out.println(removeDuplicatesCustom("iiiixxxxxiiccccczzffffflllllllllfffffllyyyyyuuuuuz", 3));
    }

    public static String removeDuplicates(String str, int k) {
        Stack<Character> charStack = new Stack<>();
        Stack<Integer> countStack = new Stack<>();
        for(char c : str.toCharArray()) {
            if(!charStack.isEmpty() && countStack.peek() >= k && charStack.peek() != c) {
                charStack.pop();
                countStack.pop();
            }
            if(charStack.isEmpty() || charStack.peek() != c) {
                charStack.push(c);
                countStack.push(1);
            } else {
                countStack.push(countStack.pop() + 1);
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!charStack.isEmpty()) {
            char c = charStack.pop();
            int n = countStack.pop();
            for(int i = 0; i < n; i++) {
                sb.append(c);
            }
        }
        return sb.reverse().toString();
    }

    public static String removeDuplicatesCustom(String str, int k) {
        class CharFreq {
            char character;
            int frequency;

            CharFreq(char character, int frequency) {
                this.character = character;
                this.frequency = frequency;
            }
        }
        Stack<CharFreq> stack = new Stack<>();
        for(int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if(!stack.isEmpty() && stack.peek().frequency >= k && stack.peek().character != c) {
                stack.pop();
            }
            if(stack.isEmpty() || stack.peek().character != c) {
                stack.push(new CharFreq(c, 1));
            } else {
                stack.peek().frequency++;
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()) {
            CharFreq cf = stack.pop();
            for(int i = 0; i < cf.frequency; i++) {
                sb.append(cf.character);
            }

        }
        return sb.reverse().toString();
    }

}
