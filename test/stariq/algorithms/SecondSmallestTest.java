package stariq.algorithms;

public class SecondSmallestTest {

    public static void main(String[] args) {

        int[] array = {2,5,1,6,9,0,-1,-3,-8,-10,-10};
        SecondSmallest.secondSmallestInteger(array);
        SecondSmallest.secondSmallestInteger(new int[] {1,6,3,9,-9,2,0});
        SecondSmallest.secondSmallestInteger(new int[] {1});
        SecondSmallest.secondSmallestInteger(new int[] {1,-1});
        SecondSmallest.secondSmallestInteger(new int[] {3,-5,-9});

    }
}
