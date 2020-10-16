package stariq.algorithms.string;

import java.util.HashSet;
import java.util.Set;

public class UniqueSubstrings {

    public static void main(String[] args) {
        System.out.println(uniqueSubstrings("abcd"));
        System.out.println(uniqueSubstrings("aaa"));
    }

    public static int uniqueSubstrings (String str) {
        Set<String> unique = new HashSet<>();
        for(int i = 0; i <= str.length(); i++) {
            for(int j = i + 1; j <= str.length(); j++) {
                String s = str.substring(i, j);
                unique.add(s);
            }
        }
        return unique.size();
    }
}
