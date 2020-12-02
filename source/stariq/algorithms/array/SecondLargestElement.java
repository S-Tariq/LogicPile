package stariq.algorithms.array;

public class SecondLargestElement {

    public static void main(String[] args) {
        int[] array = {2,5,1,6,9,0,-1,-3,-8,-10,10};
        System.out.println(secondLargest(array));
    }

    public static int secondLargest(int[] arr) {
        int first = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;
        for(int i : arr) {
            if(i > first) {
                second = first;
                first = i;
            }
            if(i > second && i < first) {
                second = i;
            }
        }
        return second;
    }
}
