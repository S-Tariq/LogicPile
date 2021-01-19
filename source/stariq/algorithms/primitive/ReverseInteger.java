package stariq.algorithms.primitive;

// https://leetcode.com/problems/reverse-integer/
public class ReverseInteger {

    public static void main(String[] args) {
        System.out.println(reverse(123));
    }

    public static int reverse(int x) {
        long reverse = 0;
        while(x != 0) {
            int remainder = x % 10;
            x = x / 10;
            reverse =  reverse * 10 + remainder;
        }
        // This portion takes care of integer overflows.
        return (int)reverse == reverse ? (int)reverse : 0;
    }
}
