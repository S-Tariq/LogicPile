package stariq.algorithms.string;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

// https://leetcode.com/problems/decode-string/
public class DecodeString {

    public static void main(String[] args) {
        System.out.println(decode("3[a2[c]]"));
     //   System.out.println(decode("100[leet]"));
    }

    public static String decode(String str) {
        Stack<Integer> repeats = new Stack<>();
        Stack<StringBuilder> characters = new Stack<>();
        characters.push(new StringBuilder());
        int repeat = 0;
        for(int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if(Character.isDigit(c)) {
                repeat = repeat * 10 + (c - '0');
            } else if (c == '[') {
                repeats.push(repeat);
                repeat = 0;
                characters.push(new StringBuilder());
            } else if (c == ']') {
                String sub = characters.pop().toString();
                int num = repeats.pop();
                StringBuilder sb = new StringBuilder();
                for(int j = 0; j < num; j++) {
                    sb.append(sub);
                }
                characters.push(characters.pop().append(sb.toString()));
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
