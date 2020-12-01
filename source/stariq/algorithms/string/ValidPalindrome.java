package stariq.algorithms.string;

// https://leetcode.com/problems/valid-palindrome/
// Check if a string is a palindrome (a word that reads the same backwards).
public class ValidPalindrome {

    public static void main(String[] args) {
//        System.out.println(isPalindromeSimple("Anna"));
//        System.out.println(isPalindromeSimple("anna"));
//        System.out.println(isPalindromeSimple("bobby "));

        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(isPalindrome("A man,; ap 02 Panama"));
    }

    public static boolean isPalindrome(String str) {
        int start = 0;
        int end = str.length() - 1;
        while(start <= end) {
            char startChar = str.charAt(start);
            char endChar = str.charAt(end);
            if(!Character.isLetterOrDigit(startChar)) {
                start++;
            } else if (!Character.isLetterOrDigit(endChar)) {
                end--;
            } else {
                if(Character.toLowerCase(startChar) != Character.toLowerCase(endChar)) {
                    return false;
                }
                start++;
                end--;
            }
        }
        return true;
    }

    // Works but time exceeded.
    public static boolean isPalindrome2(String str) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < str.length(); i++) {
            char c = str.toLowerCase().charAt(i);
            if(Character.isLetterOrDigit(c)) {
                sb.append(c);
            }
        }
        int mid = sb.length() / 2;
        for(int i = 0; i < mid; i++) {
            char start = sb.charAt(i);
            char end = sb.charAt(sb.length() - 1 - i);
            if(start != end) {
                return false;
            }
        }
        return true;
    }

    // Better implementation above as this only works for strings which contain alphabets and no spaces.
    public static boolean isPalindromeSimple(String str) {
        StringBuilder reverse = new StringBuilder();
        for(int i = str.length() - 1; i >= 0; i--) {
            reverse.append(str.charAt(i));
        }

        if(str.equalsIgnoreCase(reverse.toString())) {
            return true;
        }
        return false;
    }
}
