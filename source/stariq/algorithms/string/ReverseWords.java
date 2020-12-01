package stariq.algorithms.string;

// https://leetcode.com/problems/reverse-words-in-a-string/
// Reverse words in a string.
public class ReverseWords {

    public static void main(String[] args) {
        reverseWordsSplitBySpace("you cant see me");
        reverseWordsSplitBySpace("how are you");

        System.out.println(reverseWordsIgnoringSpace("  hello  world"));

    }

    public static void reverseWordsSplitBySpace(String str) {
        String[] words = str.split(" ");
        StringBuilder reversed = new StringBuilder();
        for(int i = words.length - 1; i >= 0; i--) {
            reversed.append(words[i]).append(" ");

        }
        // trim() ensures that there is no trailing space.
        System.out.println(reversed.toString().trim());
    }

    public static String reverseWordsIgnoringSpace(String str) {
        String[] words = str.split(" ");
        StringBuilder sb = new StringBuilder();
        for(int i = words.length - 1; i >= 0; i--) {
            if(!words[i].isEmpty()) {
                sb.append(words[i]).append(" ");
            }
        }
        return sb.toString().trim();
    }
}
