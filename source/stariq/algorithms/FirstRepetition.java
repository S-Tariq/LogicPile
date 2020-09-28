package stariq.algorithms;

import java.util.ArrayList;
import java.util.List;

public class FirstRepetition {

    public static void main(String[] args) {
        char result = FirstRepetition.firstRepeatedCharacter("albksdfkarlb");
        System.out.println(result);
        result = FirstRepetition.firstRepeatedCharacter("abcal");
        System.out.println(result);
        result = FirstRepetition.firstRepeatedCharacter("tyopky");
        System.out.println(result);
        result = FirstRepetition.firstRepeatedCharacter("qwpaslkpe");
        System.out.println(result);
    }

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
