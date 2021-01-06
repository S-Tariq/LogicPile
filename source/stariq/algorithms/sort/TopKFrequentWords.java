package stariq.algorithms.sort;

import java.util.*;

// https://leetcode.com/problems/top-k-frequent-words/
public class TopKFrequentWords {

    public static void main(String[] args) {
        String[] words = new String[] {"i", "love", "leetcode", "i", "love", "coding"};
        System.out.println(topKFrequent(words,2));
    }

    public static List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> wordMap = new TreeMap<>();
        List<String> wordList = new ArrayList<>();
        for(String s : words) {
            if(wordMap.containsKey(s)) {
                wordMap.put(s, wordMap.get(s) + 1);
            } else {
                wordMap.put(s, 1);
            }
            if(!wordList.contains(s)) {
                wordList.add(s);
            }
        }

        Collections.sort(wordList, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                int s1Count = wordMap.get(s1);
                int s2Count = wordMap.get(s2);
                int freqComp = Integer.compare(s2Count, s1Count);
                int numComp = s1.compareTo(s2);
                if(freqComp == 0) {
                    return numComp;
                }
                return freqComp;
            }
        });

        return wordList.subList(0, k);
    }
}
