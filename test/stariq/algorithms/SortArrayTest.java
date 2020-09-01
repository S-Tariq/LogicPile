package stariq.algorithms;

import org.junit.Assert;
import org.junit.Test;

public class SortArrayTest {

    private int[] unsortedArr = new int[] {3,7,6,1,9,7,5,4,2,1,0};
    private int[] sortedArr = new int[] {0,1,1,2,3,4,5,6,7,7,9};

    @Test
    public void testBubble() {
        SortArray.bubbleSort(unsortedArr);
        Assert.assertArrayEquals(unsortedArr, sortedArr);
        SortArray.print(unsortedArr);
    }

    @Test
    public void testInsertion() {
        SortArray.insertionSort(unsortedArr);
        Assert.assertArrayEquals(unsortedArr, sortedArr);
        SortArray.print(unsortedArr);
    }
    @Test
    public void testSelection() {
        SortArray.selectionSort(unsortedArr);
        Assert.assertArrayEquals(unsortedArr, sortedArr);
        SortArray.print(unsortedArr);
    }

    @Test
    public void testQuick() {
        // Array, Start index, End index
        SortArray.quickSort(unsortedArr, 0, unsortedArr.length - 1);
        Assert.assertArrayEquals(unsortedArr, sortedArr);
        SortArray.print(unsortedArr);
    }

    @Test
    public void testMerge() {
        // Array, Array length
        SortArray.mergeSort(unsortedArr, unsortedArr.length);
        Assert.assertArrayEquals(unsortedArr, sortedArr);
        SortArray.print(unsortedArr);
    }
}
