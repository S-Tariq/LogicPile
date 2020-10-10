package stariq.algorithms.string;

// Reverse words in a string.
public class ReverseWords {

    public static void main(String[] args) {
        ReverseWords.reverseWordsUsingLoop("you cant see me");
        ReverseWords.reverseWordsUsingLoop("how are you");
    }

    public static void reverseWordsUsingLoop(String str) {
        String[] words = str.split(" ");
        String reversed = "";
        for(int i = words.length - 1; i >= 0; i--) {
            // This condition avoids space at the end of sentence.
            if(i == 0) {
                reversed += words[i];
            } else {
                reversed += words[i] + " ";
            }
        }
        System.out.println(reversed);
    }
}
