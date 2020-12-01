package stariq.algorithms.string;

// https://leetcode.com/problems/string-compression/
// Compress to count the occurrence of each character.
// First method compresses string. Appends string to show character with frequency.
// aaabbbbcca -> a3b4c2a1
// Second method compresses char array. Overwrites array to show character with frequency. Does not show frequency 1.
// a,b,b,b,b,b,b,b,b,b,b,b,b,b,b,a,a -> a,b,1,4,a,2
public class CompressString {

    public static void main(String[] args) {
        String output = CompressString.compressToString("aaabbbbcc");
        System.out.println(output);

        output = CompressString.compressToString("hellooo");
        System.out.println(output);

        output = CompressString.compressToString("hi");
        System.out.println(output);

        output = CompressString.compressToString("aabc");
        System.out.println(output);

        char[] array = new char[] {'a', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'a', 'a'};
        //array = new char[] {'a', 'a', 'b', 'b', 'c', 'c', 'c'};
        int len = compressToArray(array);
        for(int i = 0; i < len; i++) {
            System.out.print(array[i] + " ");
        }
    }

    public static String compressToString(String str) {
        StringBuilder compressed = new StringBuilder();
        int count = 0;
        for(int i = 0; i < str.length(); i++) {
            count++;
            if(i == str.length() - 1 || str.charAt(i) != str.charAt(i + 1)) {
                compressed.append(str.charAt(i));
                compressed.append(count);
                count = 0;
            }
        }
        return compressed.toString();
    }

    public static String compressToString2(String str) {
        StringBuilder compressed = new StringBuilder();
        int count = 1;
        char c = str.charAt(0);
        for(int i = 0; i < str.length() - 1; i++) {
            //char c = str.charAt(i);
            char c2 = str.charAt(i + 1);
            if(c == c2) {
                count++;
            } else {
                compressed.append(c);
                compressed.append(count);
                count = 1;
                c = c2;
            }
        }
        compressed.append(c);
        compressed.append(count);
        return compressed.toString();
    }

    public static int compressToArray(char[] arr) {
        // a,b,b,b,b,b,b,b,b,b,b,b,b,b,b,a,a -> a,b,1,4,a,2
        // a,b,1,4,a,2,b,b,b,b,b,b,b,b,b,a,a
        int count = 0;
        int j = 0;
        for(int i = 0; i < arr.length; i++) {
            count++;
            if(i == arr.length - 1 || arr[i] != arr[i + 1]) {
                arr[j++] = arr[i];
                if(count > 1) {
                    char[] countArr = String.valueOf(count).toCharArray();
                    for(char c : countArr) {
                        arr[j++] = c;
                    }
                }
                count = 0;
            }
        }
        return j;
    }

    public static int compressToArray2(char[] chars) {
        int j = 0;
        int count = 1;
        char c = chars[0];
        for(int i = 0; i < chars.length; i++) {
            if(i < chars.length - 1) {
                if(c == chars[i + 1]) {
                    count++;
                    continue;
                }
            }
            String strCount = String.valueOf(count);
            chars[j++] = c;
            if(count > 1) {
                for(int k = 0; k < strCount.length(); k++) {
                    chars[j++] = strCount.charAt(k);
                }
            }
            if(i < chars.length - 1) {
                count = 1;
                c = chars[i + 1];
            }
        }
        return j;
    }

}
