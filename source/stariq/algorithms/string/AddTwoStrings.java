package stariq.algorithms.string;

// https://leetcode.com/problems/add-strings/
// - '0' is used convert character into integer.
public class AddTwoStrings {

    public static void main(String[] args) {
        System.out.println(addStrings("7243", "564"));
    }

    public static String addStrings(String num1, String num2) {
        int i = num1.length() - 1;
        int j = num2.length() - 1;

        StringBuilder result = new StringBuilder();
        int carry = 0;
        while(i >= 0 || j >= 0 || carry > 0) {
            int iChar = i >= 0 ? num1.charAt(i) - '0' : 0;
            int jChar = j >= 0 ? num2.charAt(j) - '0' : 0;
            int sum = iChar + jChar + carry;
            result.append(sum % 10);
            carry = sum / 10;
            i--;
            j--;
        }
        return result.reverse().toString();
    }
}
