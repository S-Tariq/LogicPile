package stariq.algorithms;

public class SumPairs {

    public static void main(String[] args) {
        int[] array = new int[]{2,4,3,7,2,1,4,5};
        SumPairs.findPairsForSum(array,8);
        SumPairs.findPairsForSum(array,4);
        SumPairs.findPairsForSum(array,28);
    }

    // Using loops
    public static void findPairsForSum(int[] arr, int sum) {
        int count = 0;
        String pairs = "";
        for(int i = 0; i < arr.length; i++) {
            for(int j = i + 1; j < arr.length; j++) {
                if(arr[i] + arr[j] == sum) {
                    count++;
                    pairs += "[" + arr[i] + "," + arr[j] + "] ";
                    //System.out.println(arr[i] + " + "  + arr[j] + " = " + sum);
                }
            }
        }
        if(count == 0) {
            System.out.println("No pairs found for sum " + sum);
        } else {
            System.out.println("Sum of " + sum + " has " + count + " pairs: " + pairs);
        }
    }
}
