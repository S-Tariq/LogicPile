package stariq.algorithms;

import org.junit.Assert;
import org.junit.Test;

public class FrequencySortTest {

    int[] intList = {3,3,2,1,1,0,0,0,0};
    int[] sortedInt = {2,1,1,3,3,0,0,0,0};
    String charList = "bbacccdca";
    String sortedChar = "daabbcccc";

    @Test
    public void testIntFreq() {
        Assert.assertArrayEquals(FrequencySort.intFrequencySort(intList), sortedInt);
    }

    @Test
    public void testCharFreq() {
        Assert.assertEquals(FrequencySort.charFrequencySort(charList), sortedChar);
    }
}
