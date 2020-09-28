package stariq.algorithms;

import java.util.ArrayList;
import java.util.List;

public class FirstRepetition {

    public static char firstRepeatedCharacter(String str) {

        List<Character> allChars = new ArrayList<>();
        char c = str.charAt(0);
        for(int i = 1; i < str.length(); i++) {
            if(!allChars.contains(c)) {
                allChars.add(c);
            } else {
                break;
            }
            c = str.charAt(i);
        }

        return c;
    }
}
