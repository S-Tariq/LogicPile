package stariq.algorithms.sort;

import java.util.*;

// https://leetcode.com/problems/sort-characters-by-frequency/
// Sorts an array or a string based on the frequency of the elements.
// If some elements have same frequency, then it is sorted in lexicographical order.
public class FrequencySortMap {

    public static void main(String[] args) {
        int[] intArr = new int[]{3,3,2,1,1,0,0,0,0};
        // sorted = {2,1,1,3,3,0,0,0,0}
        for(int i : intSort(intArr)) {
            System.out.print(i + " ");
        }

        System.out.println();

        String charList = "bbacccdca";
        // sorted = "daabbcccc"
        System.out.println(charSort(charList));
    }

    public static int[] intSort(int[] arr) {

        List<Integer> intList = new ArrayList<>();
        for(int i : arr) {
            intList.add(i);
        }

        Map<Integer, Integer> intMap = new HashMap<>();

        for(int i : arr) {
            if(intMap.containsKey(i)) {
                intMap.put(i, intMap.get(i) + 1);
            } else {
                intMap.put(i, 1);
            }
        }

        Comparator<Integer> comp = new Comparator<Integer>() {
            @Override
            public int compare(Integer i1, Integer i2) {
                int freqComp = intMap.get(i1).compareTo(intMap.get(i2));
                int numComp = Integer.compare(i1, i2);

                if(freqComp == 0) {
                    return numComp;
                }
                return freqComp;
            }
        };

        Collections.sort(intList, comp);

        for(int i = 0; i < intList.size(); i++) {
            arr[i] = intList.get(i);
        }
        return arr;
    }

    public static String charSort(String str) {
        List<Character> charList = new ArrayList<>();
        for(char c : str.toCharArray()) {
            charList.add(c);
        }

        Map<Character, Integer> charMap = new HashMap<>();

        for(char c : charList) {
            if(charMap.containsKey(c)) {
                charMap.put(c, charMap.get(c) + 1);
            } else {
                charMap.put(c, 1);
            }
        }

        Comparator<Character> comp = new Comparator<Character>() {
          @Override
          public int compare(Character c1, Character c2) {
              int freqComp = charMap.get(c1).compareTo(charMap.get(c2));
              int charComp = c1.compareTo(c2);
              //int charComp = Character.compare(c1,c2);

              if(freqComp == 0) {
                  return charComp;
              }
              return freqComp;
          }
        };

        Collections.sort(charList, comp);

        str = "";
        for(char c : charList) {
            str += c;
        }

        return str;
    }

}
