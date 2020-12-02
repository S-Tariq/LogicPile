package stariq.algorithms.string;

// https://leetcode.com/problems/minimum-number-of-steps-to-make-two-strings-anagram/
public class MinStepsToMakeAnagram {

    public int minSteps(String s, String t) {
        int[] array = new int[26];
        for(int i = 0; i < s.length(); i++) {
            array[s.charAt(i) - 'a']++;
            array[t.charAt(i) - 'a']--;
        }
        int count = 0;
        for(int i : array) {
            if(i != 0) {
                count += Math.abs(i);
            }
        }
        return count / 2;
    }

    public int minSteps2(String s, String t) {
        int[] array = new int[26];
        for(int i = 0; i < s.length(); i++) {
            array[s.charAt(i) - 'a']++;
            array[t.charAt(i) - 'a']--;
        }
        int count = 0;
        for(int i : array) {
            if(i < 0) {
                count += i;
            }
        }
        return Math.abs(count);
    }
}
