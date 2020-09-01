package stariq.datastructures;

import org.junit.Assert;
import org.junit.Test;

public class CharLinkedListTest {

    CharLinkedList list = new CharLinkedList();

    @Test
    public void addOneElement() {
        list.add('c');
        Assert.assertEquals('c', list.get(0));
    }

    @Test
    public void addElements() {
        list.add('d', 'r', 'y');
        Assert.assertEquals('d', list.get(0));
        Assert.assertEquals('r', list.get(1));
    }

    @Test
    public void addTwoElements() {
        list.add('k');
        list.add('p');
        Assert.assertEquals('k', list.get(0));
        Assert.assertEquals('p', list.get(1));
    }

    @Test
    public void getInvalidIndex() {
        list.add('l');
        try {
            list.get(1);
            Assert.fail("IndexOutOfBoundsException expected");
        } catch(IndexOutOfBoundsException e) {
            Assert.assertEquals("Invalid index" , e.getMessage());
        }
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void getInvalidIndex2() {
        list.add('u');
        list.get(1);
    }

    @Test
    public void setOneElement() {
        list.add('s');
        list.add('t');
        list.set(0, 'h');
        Assert.assertEquals('h', list.get(0));
        Assert.assertEquals('t', list.get(1));
    }

    @Test
    public void checkSizeOne() {
        list.add('y');
        Assert.assertEquals(1, list.size());
    }

    @Test
    public void checkSizeTwo() {
        list.add('a');
        list.add('h');
        Assert.assertEquals(2, list.size());
    }

    @Test
    public void removeMiddleElement() {
        list.add('i');
        list.add('o');
        list.add('j');
        list.remove(1);
        Assert.assertEquals('i', list.get(0));
        Assert.assertEquals('j', list.get(1));
        Assert.assertEquals(2, list.size());
    }

    @Test
    public void removeLastElement() {
        list.add('f');
        list.add('d');
        list.add('c');
        list.remove(2);
        Assert.assertEquals('f', list.get(0));
        Assert.assertEquals('d', list.get(1));
        Assert.assertEquals(2, list.size());
    }

    @Test
    public void findIndex() {
        list.add('y');
        list.add('w');
        list.add('t');
        Assert.assertEquals(1, list.indexOf('w'));
        Assert.assertEquals(-1, list.indexOf('b'));
    }

    @Test
    public void containsElement() {
        list.add('v');
        list.add('m');
        list.add('n');
        Assert.assertTrue(list.contains('n'));
        Assert.assertFalse(list.contains('e'));
    }
}
