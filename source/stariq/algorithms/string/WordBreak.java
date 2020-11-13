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

    // DP solution with memoization.
    public static boolean wordBreak(String str, List<String> wordDict) {
        Set<String> setDict = new HashSet<>();
        for(String word : wordDict) {
            setDict.add(word);
        }
        Map<String, Boolean> memo = new HashMap<>();
        return DFS(str, setDict, memo);
    }

    public static boolean DFS(String str, Set<String> dict, Map<String, Boolean> memo) {
        if(str.equals("")) {
            return true;
        }
        if(memo.containsKey(str)) {
            return memo.get(str);
        }
        for(int i = 1; i <= str.length(); i++) {
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