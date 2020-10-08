package stariq.datastructures;

import org.junit.Assert;
import org.junit.Test;
import stariq.datastructures.arraylist.CharArrayList;

public class CharArrayListTest {

    CharArrayList charArrayList = new CharArrayList();

    @Test
    public void addOneElement() {
        charArrayList.add('c');
        Assert.assertEquals('c', charArrayList.get(0));
    }

    @Test
    public void addElements() {
        charArrayList.add('b', 'd');
        Assert.assertEquals('b', charArrayList.get(0));
        Assert.assertEquals('d', charArrayList.get(1));
    }

    @Test
    public void getInvalidIndex() {
        charArrayList.add('e');
        try {
            charArrayList.get(1);
            Assert.fail("IndexOutOfBoundsException expected");
        } catch(IndexOutOfBoundsException e) {
            Assert.assertEquals("Size: 1, Index: 1" , e.getMessage());
        }
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void getInvalidIndex2() {
        charArrayList.add('t');
        charArrayList.get(1);
    }

    @Test
    public void addTwoElements() {
        charArrayList.add('s');
        charArrayList.add('t');
        Assert.assertEquals('s', charArrayList.get(0));
        Assert.assertEquals('t', charArrayList.get(1));
    }

    @Test
    public void setOneElement() {
        charArrayList.add('l');
        charArrayList.add('o');
        charArrayList.set(0, 'v');
        Assert.assertEquals('v', charArrayList.get(0));
        Assert.assertEquals('o', charArrayList.get(1));
    }

    @Test
    public void checkSizeOne() {
        charArrayList.add('u');
        Assert.assertEquals(1, charArrayList.size());
    }

    @Test
    public void checkSizeTwo() {
        charArrayList.add('k');
        charArrayList.add('h');
        Assert.assertEquals(2, charArrayList.size());
    }

    @Test
    public void removeOneElement() {
        charArrayList.add('a');
        charArrayList.add('b');
        charArrayList.add('c');
        charArrayList.remove(1);
        Assert.assertEquals('a', charArrayList.get(0));
        Assert.assertEquals('c', charArrayList.get(1));
        Assert.assertEquals(2, charArrayList.size());
    }

    @Test
    public void findIndex() {
        charArrayList.add('g');
        charArrayList.add('y');
        charArrayList.add('r');
        Assert.assertEquals(1, charArrayList.indexOf('y'));
        Assert.assertEquals(-1, charArrayList.indexOf('i'));
    }

    @Test
    public void containsElement() {
        charArrayList.add('r');
        charArrayList.add('t');
        charArrayList.add('y');
        Assert.assertTrue(charArrayList.contains('t'));
        Assert.assertFalse(charArrayList.contains('d'));
    }

}
