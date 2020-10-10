package stariq.algorithms.string;

// Check if a string is a palindrome (a word that reads the same backwards).
public class StringPalindrome {

    public static void main(String[] args) {
        System.out.println(isPalindrome("Anna"));
        System.out.println(isPalindrome("anna"));
        System.out.println(isPalindrome("bobby"));
    }

    public static boolean isPalindrome(String str) {
        String reverse = "";
        for(int i = str.length() - 1; i >= 0; i--) {
            reverse += str.charAt(i);
        }

        if(str.equalsIgnoreCase(reverse)) {
            return true;
        }
        return false;
    }
}
