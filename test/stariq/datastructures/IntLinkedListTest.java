package stariq.datastructures;

import org.junit.Assert;
import org.junit.Test;

public class IntLinkedListTest {

    IntLinkedList list = new IntLinkedList();

    @Test
    public void addOneElement() {
        list.add(4);
        Assert.assertEquals(4, list.get(0));
    }

    @Test
    public void addElements() {
        list.add(2, 4, 6);
        Assert.assertEquals(2, list.get(0));
        Assert.assertEquals(4, list.get(1));
    }

    @Test
    public void getInvalidIndex() {
        list.add(3);
        try {
            list.get(1);
            Assert.fail("IndexOutOfBoundsException expected");
        } catch(IndexOutOfBoundsException e) {
            Assert.assertEquals("Invalid index" , e.getMessage());
        }
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void getInvalidIndex2() {
        list.add(7);
        list.get(1);
    }

    @Test
    public void addTwoElements() {
        list.add(2);
        list.add(4);
        Assert.assertEquals(2, list.get(0));
        Assert.assertEquals(4, list.get(1));
    }

    @Test
    public void setOneElement() {
        list.add(2);
        list.add(4);
        list.set(0, 3);
        Assert.assertEquals(3, list.get(0));
        Assert.assertEquals(4, list.get(1));
    }

    @Test
    public void checkSizeOne() {
        list.add(2);
        Assert.assertEquals(1, list.size());
    }

    @Test
    public void checkSizeTwo() {
        list.add(2);
        list.add(5);
        Assert.assertEquals(2, list.size());
    }

    @Test
    public void removeMiddleElement() {
        list.add(3);
        list.add(5);
        list.add(8);
        list.remove(1);
        Assert.assertEquals(3, list.get(0));
        Assert.assertEquals(8, list.get(1));
        Assert.assertEquals(2, list.size());
    }

    @Test
    public void removeLastElement() {
        list.add(4);
        list.add(7);
        list.add(1);
        list.remove(2);
        Assert.assertEquals(4, list.get(0));
        Assert.assertEquals(7, list.get(1));
        Assert.assertEquals(2, list.size());
    }

    @Test
    public void findIndex() {
        list.add(3);
        list.add(2);
        list.add(3);
        Assert.assertEquals(1, list.indexOf(2));
        Assert.assertEquals(-1, list.indexOf(4));
    }

    @Test
    public void containsElement() {
        list.add(3);
        list.add(2);
        list.add(6);
        Assert.assertTrue(list.contains(3));
        Assert.assertFalse(list.contains(5));
    }
}
