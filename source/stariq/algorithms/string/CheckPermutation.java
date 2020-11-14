package stariq.algorithms.string;

// https://leetcode.com/problems/permutation-in-string/
public class CheckPermutation {

    public static void main(String[] args) {
        System.out.println(checkPermutation("abd", "eidebaoo"));
    }

    public static boolean checkPermutation(String s1, String s2) {
        if(s1.length() > s2.length()) {
            return false;
        }
        int[] count = new int[26];
        for(char c : s1.toCharArray()) {
            count[c - 'a']++;
        }
        int counter = s1.length();
        int j = 0;
        while(j < s1.length()) {
            char c = s2.charAt(j);
            if(count[c - 'a']-- > 0) {
                counter--;
            }
            j++;
        }
        int i = 0;
        while(j < s2.length() && counter != 0) {
            char start = s2.charAt(i);
            char end = s2.charAt(j);
            if(count[start - 'a']++ >= 0) {
                counter++;
            }
            if(count[end - 'a']-- > 0) {
                counter--;
            }
            i++;
            j++;
        }
        return counter == 0;
    }
}
