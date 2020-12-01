package stariq.algorithms.string;

// https://leetcode.com/problems/valid-anagram/
// Check if two strings are an anagram (a word formed by rearranging another word)
public class ValidAnagram {
    public static void main(String[] args) {
        System.out.println(isAnagram("rat", "car"));
        System.out.println(isAnagram("anagram", "nagaram"));
    }

    public static boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) {
            return false;
        }
        int[] array = new int[26];
        for(int i = 0; i < s.length(); i++) {
            array[s.charAt(i) - 'a']++;
            array[t.charAt(i) - 'a']--;
        }
        for(int i : array) {
            if(i != 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean isAnagram2(String s, String t) {
        if(s.length() != t.length()) {
            return false;
        }
        int[] sArray = new int[26];
        int[] tArray = new int[26];
        for(int i = 0; i < s.length(); i++) {
            sArray[s.charAt(i) - 'a']++;
            tArray[t.charAt(i) - 'a']++;
        }
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(sArray[c - 'a'] != tArray[c - 'a']) {
                return false;
            }
        }
        return true;
    }
}
