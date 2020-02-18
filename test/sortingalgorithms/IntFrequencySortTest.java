package sortingalgorithms;

public class IntFrequencySortTest {

    public static void main(String[] args) {

        int[] arr = {2,3,3,1,1,0,0,0,0};
        for(int i : IntFrequencySort.intFrequency(arr)) {
            System.out.print(i + " ");
        }
    }

}
