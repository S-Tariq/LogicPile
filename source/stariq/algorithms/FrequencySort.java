package stariq.algorithms;


import java.util.*;

public class FrequencySort {

    public static int[] intFrequencySort(int[] arr) {
        List<Integer> list = new ArrayList<>();
        for(int i : arr) {
            list.add(i);
        }
        Map<Integer, Integer> map = new HashMap<>();
        for(int i : list) {
            if(map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
            } else {
                map.put(i, 1);
            }
        }
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer i1, Integer i2) {
                int freqComp = map.get(i1).compareTo(map.get(i2));
                int numComp = i1.compareTo(i2);
                if(freqComp == 0) {
                    return numComp;
                } else {
                    return freqComp;
                }
            }
        });
        for(int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i);
        }
        return arr;
    }

    public static String charFrequencySort(String s) {
        ArrayList<CharFreq> charCount = new ArrayList<>();
        charCount.add(new CharFreq(s.charAt(0)));
        for(int i = 1; i < s.length(); i++) {
            char c = s.charAt(i);
            boolean foundChar = false;
            for(CharFreq cf : charCount) {
                if(cf.getCharacter() == c) {
                    foundChar = true;
                    cf.incrementFreq();
                }
            }
            if(!foundChar) {
                charCount.add(new CharFreq(c));
            }
        }
        Collections.sort(charCount, new Comparator<CharFreq>() {
            @Override
            public int compare(CharFreq cf1, CharFreq cf2) {
                int freqComp = Integer.compare(cf1.getFrequency(), cf2.getFrequency());
                int charComp = Character.compare(cf1.getCharacter(), cf2.getCharacter());
                if(freqComp == 0) {
                    return charComp;
                } else {
                    return freqComp;
                }
            }
        });
        StringBuilder sb = new StringBuilder();
        for(CharFreq cf : charCount) {
            for(int i = 0; i < cf.getFrequency(); i++) {
                sb.append(cf.getCharacter());
            }
        }
        return sb.toString();
    }
}

class CharFreq {
    private char character;
    private int frequency;

    public CharFreq(char c) {
        character = c;
        frequency = 1;
    }

    public char getCharacter() {
        return character;
    }

    public int getFrequency() {
        return frequency;
    }

    public void incrementFreq() {
        frequency++;
    }
}
