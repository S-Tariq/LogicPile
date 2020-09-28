package stariq.algorithms;

public class StringCompression {

    public static void main(String[] args) {
        String output = StringCompression.compressString("aaabbbbcc");
        System.out.println(output);

        output = StringCompression.compressString("hellooo");
        System.out.println(output);

        output = StringCompression.compressString("hi");
        System.out.println(output);

        output = StringCompression.compressString("aabc");
        System.out.println(output);
    }

    public static String compressString(String str) {

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

}
