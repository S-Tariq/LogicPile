package sortingalgorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class CharFrequencySort {

    public static String charFrequency(String s) {

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
