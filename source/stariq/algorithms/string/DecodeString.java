package stariq.algorithms.string;

import java.util.Stack;

// https://leetcode.com/problems/decode-string/
public class DecodeString {

    public static void main(String[] args) {
        System.out.println(decode("3[a2[c]]"));
        // 3[acc]
        // accaccacc
        System.out.println(decode("12[leet]"));
    }

    public static String decode(String str) {
        Stack<Integer> repeats = new Stack<>();
        Stack<StringBuilder> characters = new Stack<>();
        characters.push(new StringBuilder());
        int count = 0;
        for(int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if(Character.isDigit(c)) {
                // Takes care of count greater than 1 digit.
                count = count * 10 + (c - '0');
            } else if (c == '[') {
                repeats.push(count);
                count = 0;
                characters.push(new StringBuilder());
            } else if (c == ']') {
                String sub = characters.pop().toString();
                int num = repeats.pop();
                StringBuilder temp = new StringBuilder();
                for(int j = 0; j < num; j++) {
                    temp.append(sub);
                }
                characters.push(characters.pop().append(temp.toString()));
            } else {
                characters.peek().append(c);
            }
        }
        return characters.pop().toString();
    }

    // Lengthy - First attempt
    public static String decode2(String str) {
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder(str);

        int repeat = 0;
        StringBuilder repeatSB = new StringBuilder();

        for(int i = 0; i < sb.length(); i++) {
            char c = sb.charAt(i);
            if(Character.isDigit(c)) {
                repeatSB.append(c);
                repeat = Integer.parseInt(repeatSB.toString());
            }
            if(c == '[') {
                stack.push(i);
                repeatSB = new StringBuilder();
            }
            if(c == ']') {
                int start = stack.pop();
                StringBuilder sub = new StringBuilder(sb.substring(start + 1, i));
                StringBuilder repeatSub = new StringBuilder();
                int j = 0;
                while(j < repeat) {
                    repeatSub.append(sub);
                    j++;
                }
                sb.replace(start - String.valueOf(repeat).length(), i + 1, repeatSub.toString());
                i = -1;
            }
        }
        return sb.toString();
    }
}
