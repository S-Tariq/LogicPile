package stariq.algorithms.string;

// Given a number, find the corresponding word.
public class CorrespondingWord {

    public static void main(String[] args) {
        String number = "01234";
        System.out.println(word2(number));
        number = "7-14-22 0-17-4 24-14-20?";
        System.out.println(word(number));
    }

    public static String word(String sentence) {
        StringBuilder sb = new StringBuilder();
        int number = 0;
        for(char c : sentence.toCharArray()) {
            if(Character.isDigit(c)) {
                number = number * 10 + c - '0';
            } else {
                char character = (char)(number + 'A');
                sb.append(character);
                if(c != '-') {
                    sb.append(c);
                }
                number = 0;
            }
        }
        return sb.toString();
    }

    // Only works for single digit alphabet numbers.
    public static String word2(String number) {
        StringBuilder sb = new StringBuilder();
        for(char c : number.toCharArray()) {
            int digit = c - '0';
            char character = (char)(digit + 'A');
            sb.append(character);
        }
        return sb.toString();
    }
}
