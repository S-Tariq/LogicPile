package stariq.algorithms;

public class FirstRepetitionTest {

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
}
