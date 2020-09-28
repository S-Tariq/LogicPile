package stariq.algorithms;

public class StringCompressionTest {

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
}
