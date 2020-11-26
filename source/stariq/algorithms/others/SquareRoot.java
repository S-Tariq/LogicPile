package stariq.algorithms.others;

public class SquareRoot {

    public static void main(String[] args) {
        System.out.println(mySqrt(16));
        System.out.println(mySqrt(8));
    }

    public static int mySqrt(int x) {
        long i = x;
        while(i * i > x) {
            i = (i + x/i)/2;
        }
        return (int) i;
    }
}
