package stariq.datastructures;

import org.junit.Assert;
import org.junit.Test;
import stariq.datastructures.arraylist.ArrayListForInt;

public class ArrayListForIntTest {

    ArrayListForInt arrayListForInt = new ArrayListForInt();

    @Test
    public void addOneElement() {
        arrayListForInt.add(4);
        Assert.assertEquals(4, arrayListForInt.get(0));
    }

    @Test
    public void addElements() {
        arrayListForInt.add(2, 4, 6);
        Assert.assertEquals(2, arrayListForInt.get(0));
        Assert.assertEquals(4, arrayListForInt.get(1));
    }

    @Test
    public void getInvalidIndex() {
        arrayListForInt.add(3);
        try {
            arrayListForInt.get(1);
            Assert.fail("IndexOutOfBoundsException expected");
        } catch(IndexOutOfBoundsException e) {
            Assert.assertEquals("Size: 1, Index: 1" , e.getMessage());
        }
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void getInvalidIndex2() {
        arrayListForInt.add(7);
        arrayListForInt.get(1);
    }

    @Test
    public void addTwoElements() {
        arrayListForInt.add(2);
        arrayListForInt.add(4);
        Assert.assertEquals(2, arrayListForInt.get(0));
        Assert.assertEquals(4, arrayListForInt.get(1));
    }

    @Test
    public void setOneElement() {
        arrayListForInt.add(2);
        arrayListForInt.add(4);
        arrayListForInt.set(0, 3);
        Assert.assertEquals(3, arrayListForInt.get(0));
        Assert.assertEquals(4, arrayListForInt.get(1));
    }

    @Test
    public void checkSizeOne() {
        arrayListForInt.add(2);
        Assert.assertEquals(1, arrayListForInt.size());
    }

    @Test
    public void checkSizeTwo() {
        arrayListForInt.add(2);
        arrayListForInt.add(5);
        Assert.assertEquals(2, arrayListForInt.size());
    }

    @Test
    public void removeOneElement() {
        arrayListForInt.add(3);
        arrayListForInt.add(2);
        arrayListForInt.add(3);
        arrayListForInt.remove(1);
        Assert.assertEquals(3, arrayListForInt.get(0));
        Assert.assertEquals(3, arrayListForInt.get(1));
    }

    @Test
    public void findIndex() {
        arrayListForInt.add(3);
        arrayListForInt.add(2);
        arrayListForInt.add(3);
        Assert.assertEquals(1, arrayListForInt.indexOf(2));
        Assert.assertEquals(-1, arrayListForInt.indexOf(4));
    }

    @Test
    public void containsElement() {
        arrayListForInt.add(3);
        arrayListForInt.add(2);
        arrayListForInt.add(6);
        Assert.assertTrue(arrayListForInt.contains(3));
        Assert.assertFalse(arrayListForInt.contains(5));
    }
}
