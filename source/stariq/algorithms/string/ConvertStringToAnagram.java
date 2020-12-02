package stariq.algorithms.string;

// Assuming s and t are the same length.
public class ConvertStringToAnagram {

    public static void main(String[] args) {
        System.out.println(convertToAnagram("abaf", "baat"));
        System.out.println(convertToAnagram2("abaf", "baat"));
        System.out.println(convertToAnagram2("wabaf", "baatr"));
    }

    // Changes s to become an anagram of t.
    public static String convertToAnagram(String s, String t) {
        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();
        int[] countS = new int[26];
        int[] countT = new int[26];
        int[] diffS = new int[26];
        int[] diffT = new int[26];

        for(int i = 0; i < sArr.length; i++) {
            countS[sArr[i] - 'a']++;
            countT[tArr[i] - 'a']++;
        }

        for(int i = 0; i < countS.length; i++) {
            if(countS[i] > countT[i]) {
                diffS[i] += countS[i] - countT[i];
            } else if (countS[i] < countT[i]) {
                diffT[i] += countT[i] - countS[i];
            }
        }

        for(int i = 0; i < s.length(); i++) {
            if(diffS[sArr[i] - 'a'] == 0) {
                continue;
            }
            int j = 0;
            while(j < countS.length) {
                if(diffT[j] > 0) {
                    break;
                }
                j++;
            }
            if(countS[sArr[i] - 'a'] == diffS[sArr[i] - 'a'] || sArr[i] - 'a' > j) {
                countS[sArr[i] - 'a']--;
                diffS[sArr[i] - 'a']--;
                diffT[j]--;
                sArr[i] = (char)('a' + j);
            } else {
                countS[sArr[i] - 'a']--;
            }
        }
        return String.valueOf(sArr);
    }

    // Changes t to become an anagram of s.
    public static String convertToAnagram2(String s, String t) {
        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();
        int[] countS = new int[26];
        int[] countT = new int[26];
        int[] diffS = new int[26];
        int[] diffT = new int[26];

        for(int i = 0; i < sArr.length; i++) {
            countS[sArr[i] - 'a']++;
            countT[tArr[i] - 'a']++;
        }

        for(int i = 0; i < countS.length; i++) {
            if(countS[i] > countT[i]) {
                diffS[i] += countS[i] - countT[i];
            } else if (countS[i] < countT[i]) {
                diffT[i] += countT[i] - countS[i];
            }
        }

        for(int i = 0; i < tArr.length; i++) {
            if(diffT[tArr[i] - 'a'] == 0) {
                continue;
            }
            int j = 0;
            while(j < countT.length) {
                if(diffS[j] > 0) {
                    break;
                }
                j++;
            }
            if(countT[tArr[i] - 'a'] == diffT[tArr[i] - 'a'] || tArr[i] - 'a' > j) {
                countT[tArr[i] - 'a']--;
                diffT[tArr[i] - 'a']--;
                diffS[j]--;
                tArr[i] = (char)('a' + j);
            } else {
                countT[tArr[i] - 'a']--;
            }
        }
        return String.valueOf(tArr);
    }


}
