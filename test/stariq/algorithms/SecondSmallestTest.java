package stariq.algorithms;

public class SecondSmallestTest {

    public static void main(String[] args) {

        int[] array = {2,5,1,6,9,0,-1,-3,-8,-10,-10};
        SecondSmallest.secondSmallest(array);
        SecondSmallest.secondSmallest(new int[] {1,6,3,9,-9,2,0});
        SecondSmallest.secondSmallest(new int[] {1});
        SecondSmallest.secondSmallest(new int[] {1,-1});
        SecondSmallest.secondSmallest(new int[] {3,-5,-9});

    }
}
