package stariq.algorithms;

public class CommonCharInStrings {

    public static void main(String[] args) {
        String str1 = "abfhsdsgg";
        String str2 = "abyeolsgg";
        System.out.println(commonChars(str1, str2));
    }

    public static String commonChars(String str1, String str2) {
        StringBuilder common = new StringBuilder();
        int[] arr = new int[26];

        for(int i = 0; i < str1.length(); i++) {
            char c = str1.charAt(i);
            arr[c - 'a']++;
        }

        for(int i = 0; i < str2.length(); i++) {
            char c = str2.charAt(i);
            if(arr[c - 'a'] > 0) {
                common.append(c);
                arr[c - 'a']--;
            }
        }
        return common.toString();
    }

}
