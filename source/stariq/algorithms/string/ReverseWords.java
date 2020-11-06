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
            // This condition avoids space at the end of sentence.
            if(i == 0) {
                reversed.append(words[i]);
            } else {
                reversed.append(words[i]).append(" ");
            }
        }
        System.out.println(reversed.toString());
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
