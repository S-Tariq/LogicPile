package stariq.algorithms;

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
