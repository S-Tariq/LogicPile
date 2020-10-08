package stariq.algorithms;

import java.util.ArrayList;
import java.util.List;

// Find all the permutations of a given string (all unique arrangements of characters in a string).
public class StringPermutations {

    public static void main(String[] args) {
        permutation("ABC", 0, 2);

        System.out.println();

        for(String s : permutation2("ABC", 0, 3)) {
            System.out.print(s + " ");
        }
    }

    // Simpler method. The end parameter can be removed as it does not change.
    // Better to leave end parameter if only permutations of substring needs to be found.
    // Return type is void - just prints out all the permutations.
    public static void permutation(String str, int start, int end) {
        if(start == end) {
            System.out.print(str + " ");
        } else {
            for(int i = start; i <= end; i++) {
                String swapped = swap(str, start, i);
                permutation(swapped, start + 1, end);
            }
        }
    }

    // Return type is a list - adds them to a static list.
    // The list cannot be local as recursion will keep resetting it to null.
    static List<String> permutations2 = new ArrayList<>();
    public static List<String> permutation2(String str, int start, int len) {
        if(start == len - 1) {
            permutations2.add(str);
        } else {
            for(int i = start; i < len; i++) {
                str = swap(str, start, i);
                permutation2(str, start + 1, len);
                str = swap(str, start , i);
            }
        }
        return permutations2;
    }

    // Swap method used in both implementations of permutations.
    private static String swap(String str, int i, int j) {
        char[] chars = str.toCharArray();
        char c = chars[i];
        chars[i] = chars[j];
        chars[j] = c;
        return String.valueOf(chars);
    }


}
