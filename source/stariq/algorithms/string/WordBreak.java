package stariq.algorithms.string;

import java.util.*;

// https://leetcode.com/problems/word-break/
public class WordBreak {

    public static void main(String[] args) {
        String s = "leetcode";
        List<String> dict = new ArrayList<>();
        dict.addAll(Arrays.asList("leet", "code"));

        System.out.println(wordBreak(s, dict));
    }

    // DP with memoization - without set.
    public static boolean wordBreak(String str, List<String> dict) {
        Map<String, Boolean> map = new HashMap<>();
        return dfs(str,dict, map);
    }

    public static boolean dfs(String str, List<String> dict, Map<String,Boolean> map) {
        if(str.equals("")) {
            return true;
        }
        if(map.containsKey(str)) {
            return map.get(str);
        }
        for(int i = 1; i <= str.length(); i++) {
            boolean dfs = dfs(str.substring(i), dict, map);
            if(dict.contains(str.substring(0, i)) && dfs) {
                map.put(str.substring(i), true);
                return true;
            }
        }
        map.put(str, false);
        return false;
    }

    // DP solution with memoization.
    public static boolean wordBreakWithSet(String str, List<String> wordDict) {
        Set<String> setDict = new HashSet<>();
        // Put all words in set because of fast look-up time.
        for(String word : wordDict) {
            setDict.add(word);
        }
        // Map is used for memoization.
        Map<String, Boolean> memo = new HashMap<>();
        return DFS(str, setDict, memo);
    }

    public static boolean DFS(String str, Set<String> dict, Map<String, Boolean> memo) {
        if(str.equals("")) {
            return true;
        }
        // If the map already contains the substring, we dont need to do dfs again.
        if(memo.containsKey(str)) {
            return memo.get(str);
        }
        for(int i = 1; i <= str.length(); i++) {
            // If dictionary contains sub-word and
            // the rest of the substring in DFS is true: return true;
            boolean dfs = DFS(str.substring(i), dict, memo);
            if(dict.contains(str.substring(0, i)) && dfs) {
                memo.put(str.substring(i), true);
                return true;
            }
        }
        memo.put(str, false);
        return false;
    }
}
