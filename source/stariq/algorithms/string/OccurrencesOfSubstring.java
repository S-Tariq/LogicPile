package stariq.algorithms.string;

public class OccurrencesOfSubstring {

    public static void main(String[] args) {
        System.out.println(occurrences("matterofman", "ma"));
        System.out.println(occurrences("aaaaa ", "aa"));
    }

    public static int occurrences(String string, String sub) {
        int count = 0;
        for(int i = 0; i < string.length() - sub.length(); i++) {
            if(string.substring(i, i + sub.length()).equals(sub)) {
                count++;
            }
        }
        return count;
    }
}
