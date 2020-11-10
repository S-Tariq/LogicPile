package stariq.algorithms.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

// Sorts an array or a string based on the frequency of the elements.
// If some elements have same frequency, then it is sorted in lexicographical order.
public class FrequencySortCustomClass {

    public static void main(String[] args) {

        String charList = "bbacccdca";
        // sorted = "daabbcccc"
        System.out.println(frequencySort(charList));

    }

    public static String frequencySort(String str) {
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
