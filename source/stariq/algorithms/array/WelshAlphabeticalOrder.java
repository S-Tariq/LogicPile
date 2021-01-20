package stariq.algorithms.array;

import java.util.*;

public class WelshAlphabeticalOrder {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("ddf");
        list.add("dde");
        list.add("a");
        list.add("df");
        list.add("g");
        list.add("b");
        list.add("ng");
        // a, b, dde, ddf, df, g, ng

        System.out.println(list);
        alphabetSort(list);
        System.out.println(list);

    }

    public static void alphabetSort(List<String> words) {
        String[] alphabet = new String[] {"a","b","c","ch","dd","d","e", "f", "ff", "g", "ng", "h", "i", "j", "l", "ll", "m", "n", "o", "p", "ph", "r", "rh", "s", "t", "th", "u", "w", "y"};
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i < alphabet.length; i++) {
            map.put(alphabet[i], i);
        }
        Collections.sort(words, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                System.out.println(a);
                System.out.println(b);
                if (a.equals(b)) {
                    return 0;
                }
                int baseIdx = 0;
                while (a.charAt(baseIdx) == b.charAt(baseIdx)) {
                    baseIdx++;
                }
                if (baseIdx == a.length()) {
                    return 1;
                }
                if (baseIdx == b.length()) {
                    return -1;
                }
                int aIdx = Math.max(baseIdx - 1, 0);
                int bIdx = aIdx;

                int aChars = Math.min(2, a.length() - aIdx);
                int bChars = Math.min(2, b.length() - bIdx);

                String aSub = a.substring(aIdx, aIdx + aChars);
                String bSub = b.substring(bIdx, bIdx + bChars);

                if (!map.containsKey(aSub)) {
                    if (map.containsKey(aSub.charAt(0))) {
                        aSub = String.valueOf(aSub.charAt(0));
                    }
                }
                if (!map.containsKey(bSub)) {
                    if (map.containsKey(bSub.charAt(0))) {
                        bSub = String.valueOf(bSub.charAt(0));
                    }
                }
                return map.get(aSub).compareTo(map.get(bSub));
            }
        });
    }
}
