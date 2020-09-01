package stariq.datastructures;

import org.junit.Assert;
import org.junit.Test;

public class IntArrayListTest {

    IntArrayList intArrayList = new IntArrayList();

    @Test
    public void addOneElement() {
        intArrayList.add(4);
        Assert.assertEquals(4, intArrayList.get(0));
    }

    @Test
    public void addElements() {
        intArrayList.add(2, 4, 6);
        Assert.assertEquals(2, intArrayList.get(0));
        Assert.assertEquals(4, intArrayList.get(1));
    }

    @Test
    public void getInvalidIndex() {
        intArrayList.add(3);
        try {
            intArrayList.get(1);
            Assert.fail("IndexOutOfBoundsException expected");
        } catch(IndexOutOfBoundsException e) {
            Assert.assertEquals("Size: 1, Index: 1" , e.getMessage());
        }
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void getInvalidIndex2() {
        intArrayList.add(7);
        intArrayList.get(1);
    }

    @Test
    public void addTwoElements() {
        intArrayList.add(2);
        intArrayList.add(4);
        Assert.assertEquals(2, intArrayList.get(0));
        Assert.assertEquals(4, intArrayList.get(1));
    }

    @Test
    public void setOneElement() {
        intArrayList.add(2);
        intArrayList.add(4);
        intArrayList.set(0, 3);
        Assert.assertEquals(3, intArrayList.get(0));
        Assert.assertEquals(4, intArrayList.get(1));
    }

    @Test
    public void checkSizeOne() {
        intArrayList.add(2);
        Assert.assertEquals(1, intArrayList.size());
    }

    @Test
    public void checkSizeTwo() {
        intArrayList.add(2);
        intArrayList.add(5);
        Assert.assertEquals(2, intArrayList.size());
    }

    @Test
    public void removeOneElement() {
        intArrayList.add(3);
        intArrayList.add(2);
        intArrayList.add(3);
        intArrayList.remove(1);
        Assert.assertEquals(3, intArrayList.get(0));
        Assert.assertEquals(3, intArrayList.get(1));
    }

    @Test
    public void findIndex() {
        intArrayList.add(3);
        intArrayList.add(2);
        intArrayList.add(3);
        Assert.assertEquals(1, intArrayList.indexOf(2));
        Assert.assertEquals(-1, intArrayList.indexOf(4));
    }

    @Test
    public void containsElement() {
        intArrayList.add(3);
        intArrayList.add(2);
        intArrayList.add(6);
        Assert.assertTrue(intArrayList.contains(3));
        Assert.assertFalse(intArrayList.contains(5));
    }
}
