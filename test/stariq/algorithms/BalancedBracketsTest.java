package stariq.algorithms;

public class BalancedBracketsTest {

    public static void main(String[] args) {
        addBrackets("{[]}");
        addBrackets("{}{]");
    }

    public static void addBrackets(String s){

        boolean isValid = BalancedBrackets.isBalanced(s);
        if (isValid) {
            System.out.println("String is valid");
        } else {
            System.out.println("String is invalid");
        }
    }
}
