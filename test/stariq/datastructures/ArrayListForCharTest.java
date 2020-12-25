package stariq.datastructures;

import org.junit.Assert;
import org.junit.Test;
import stariq.datastructures.arraylist.ArrayListForChar;

public class ArrayListForCharTest {

    ArrayListForChar arrayListForChar = new ArrayListForChar();

    @Test
    public void addOneElement() {
        arrayListForChar.add('c');
        Assert.assertEquals('c', arrayListForChar.get(0));
    }

    @Test
    public void addElements() {
        arrayListForChar.add('b', 'd');
        Assert.assertEquals('b', arrayListForChar.get(0));
        Assert.assertEquals('d', arrayListForChar.get(1));
    }

    @Test
    public void getInvalidIndex() {
        arrayListForChar.add('e');
        try {
            arrayListForChar.get(1);
            Assert.fail("IndexOutOfBoundsException expected");
        } catch(IndexOutOfBoundsException e) {
            Assert.assertEquals("Size: 1, Index: 1" , e.getMessage());
        }
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void getInvalidIndex2() {
        arrayListForChar.add('t');
        arrayListForChar.get(1);
    }

    @Test
    public void addTwoElements() {
        arrayListForChar.add('s');
        arrayListForChar.add('t');
        Assert.assertEquals('s', arrayListForChar.get(0));
        Assert.assertEquals('t', arrayListForChar.get(1));
    }

    @Test
    public void setOneElement() {
        arrayListForChar.add('l');
        arrayListForChar.add('o');
        arrayListForChar.set(0, 'v');
        Assert.assertEquals('v', arrayListForChar.get(0));
        Assert.assertEquals('o', arrayListForChar.get(1));
    }

    @Test
    public void checkSizeOne() {
        arrayListForChar.add('u');
        Assert.assertEquals(1, arrayListForChar.size());
    }

    @Test
    public void checkSizeTwo() {
        arrayListForChar.add('k');
        arrayListForChar.add('h');
        Assert.assertEquals(2, arrayListForChar.size());
    }

    @Test
    public void removeOneElement() {
        arrayListForChar.add('a');
        arrayListForChar.add('b');
        arrayListForChar.add('c');
        arrayListForChar.remove(1);
        Assert.assertEquals('a', arrayListForChar.get(0));
        Assert.assertEquals('c', arrayListForChar.get(1));
        Assert.assertEquals(2, arrayListForChar.size());
    }

    @Test
    public void findIndex() {
        arrayListForChar.add('g');
        arrayListForChar.add('y');
        arrayListForChar.add('r');
        Assert.assertEquals(1, arrayListForChar.indexOf('y'));
        Assert.assertEquals(-1, arrayListForChar.indexOf('i'));
    }

    @Test
    public void containsElement() {
        arrayListForChar.add('r');
        arrayListForChar.add('t');
        arrayListForChar.add('y');
        Assert.assertTrue(arrayListForChar.contains('t'));
        Assert.assertFalse(arrayListForChar.contains('d'));
    }

}
