package stariq.algorithms.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

// https://leetcode.com/problems/sort-characters-by-frequency/
// Sorts an array or a string based on the frequency of the elements.
// If some elements have same frequency, then it is sorted in lexicographical order.
public class FrequencySortCustom {

    public static void main(String[] args) {

        String charList = "bbacccdca";
        // sorted = "daabbcccc"
        System.out.println(frequencySort(charList));

    }

    public static String frequencySort(String str) {
        class CharFreq {
            private char character;
            private int frequency;

            CharFreq(char character, int frequency) {
                this.character = character;
                this.frequency = frequency;
            }

            public char getCharacter() {
                return this.character;
            }

            public int getFrequency() {
                return this.frequency;
            }

            public void incrementFrequency() {
                this.frequency++;
            }

            @Override
            public boolean equals(Object obj) {
                if(obj == null) {
                    return false;
                }

                if(obj == this) {
                    return true;
                }

                if(obj instanceof CharFreq) {
                    CharFreq cf = (CharFreq) obj;
                    return cf.character == character;
                } else {
                    return false;
                }
            }
        }

        if(str.length() == 0) {
            return str;
        }

        List<CharFreq> list = new ArrayList<>();
        for(char c : str.toCharArray()) {
            CharFreq temp = new CharFreq(c, 1);
            boolean present = false;
            for(CharFreq cf : list) {
                if(cf.equals(temp)) {
                    cf.incrementFrequency();
                    present = true;
                }
            }
            if(!present) {
                list.add(temp);
            }
        }
        Collections.sort(list, new Comparator<CharFreq>() {
            @Override
            public int compare(CharFreq a, CharFreq b) {
                int freqComp = Integer.compare(a.getFrequency(), b.getFrequency());
                int charComp = Character.compare(a.getCharacter(), b.getCharacter());

                if(freqComp == 0) {
                    return charComp;
                } else {
                    return freqComp;
                }
            }
        });

        StringBuilder sb = new StringBuilder();
        for(CharFreq cf : list) {
            for(int i = 0; i < cf.getFrequency(); i++) {
                sb.append(cf.getCharacter());
            }
        }
        return sb.toString();
    }

    public static String frequencySort2(String str) {

        class CharFrequency {
            private char character;
            private int frequency;

            CharFrequency(char character, int frequency) {
                this.character = character;
                this.frequency = frequency;
            }

            public char getCharacter() {
                return this.character;
            }

            public int getFrequency() {
                return this.frequency;
            }

            public void incrementFrequency() {
                this.frequency++;
            }
        }

        if(str.length() == 0){
            return str;
        }

        List<CharFrequency> charList = new ArrayList<>();
        charList.add(new CharFrequency(str.charAt(0), 0));
        for(char c : str.toCharArray()) {
            boolean present = false;
            for(CharFrequency cf : charList) {
                if(cf.getCharacter() == c) {
                    cf.incrementFrequency();
                    present = true;
                }
            }
            if(!present) {
                charList.add(new CharFrequency(c, 1));
            }
        }

        Comparator<CharFrequency> comp = new Comparator<CharFrequency>() {
            @Override
            public int compare(CharFrequency cf1, CharFrequency cf2) {
                int freqComp = Integer.compare(cf1.getFrequency(), cf2.getFrequency());
                int charComp = Character.compare(cf1.getCharacter(), cf2.getCharacter());

                if(freqComp == 0) {
                    return charComp;
                }
                return freqComp;
            }
        };

        Collections.sort(charList, comp);

        StringBuilder sb = new StringBuilder();
        for(CharFrequency cf : charList) {
            for(int i = 0; i < cf.getFrequency(); i++) {
                sb.append(cf.getCharacter());
            }
        }
        return sb.toString();
    }
}
