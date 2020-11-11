package stariq.datastructures;

import org.junit.Assert;
import org.junit.Test;
import stariq.datastructures.arraylist.GenericsArrayList;

public class GenericsArrayListTest {

    GenericsArrayList<Character> charList = new GenericsArrayList<>();
    GenericsArrayList<Integer> intList = new GenericsArrayList<>();

    @Test
    public void addOneElement() {
        charList.add('b');
        Assert.assertEquals((Object)'b', charList.get(0));

        intList.add(2);
        Assert.assertEquals((Object) 2, intList.get(0));
    }

    @Test
    public void addElements() {
        charList.add('a', 'b');
        Assert.assertEquals((Object)'a', charList.get(0));
        Assert.assertEquals((Object)'b', charList.get(1));

        intList.add(1,2,3);
        Assert.assertEquals((Object)1, intList.get(0));
        Assert.assertEquals((Object)3, intList.get(2));
    }

    @Test
    public void getInvalidIndex() {
        charList.add('p');
        try {
            charList.get(1);
            Assert.fail("IndexOutOfBoundsException expected");
        } catch(IndexOutOfBoundsException e) {
            Assert.assertEquals("Invalid Index! Size: 1, Index: 1", e.getMessage());
        }

        intList.add(6);
        try {
            intList.get(2);
            Assert.fail("IndexOutOfBoundsException expected");
        } catch(IndexOutOfBoundsException e) {
            Assert.assertEquals("Invalid Index! Size: 1, Index: 2" , e.getMessage());
        }
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void getInvalidIndex2() {
        charList.add('y');
        charList.get(1);

        intList.add(9);
        intList.get(2);
    }

    @Test
    public void checkSize() {
        charList.add('f');
        charList.add('r');
        charList.add('z');
        Assert.assertEquals(3,charList.size());

        intList.add(2);
        intList.add(4);
        Assert.assertEquals(2,intList.size());
    }

    @Test
    public void setOneElement() {
        charList.add('h');
        charList.add('x');
        charList.set(0, 'o');
        Assert.assertEquals((Object)'o', charList.get(0));
        Assert.assertEquals((Object)'x', charList.get(1));

        intList.add(4);
        intList.add(2);
        intList.set(1, 8);
        Assert.assertEquals((Object)4, intList.get(0));
        Assert.assertEquals((Object)8, intList.get(1));
    }

    @Test
    public void removeOneElement() {
        charList.add('a');
        charList.add('b');
        charList.add('c');
        charList.remove(1);
        Assert.assertEquals((Object)'a', charList.get(0));
        Assert.assertEquals((Object)'c', charList.get(1));
        Assert.assertEquals(2, charList.size());

        intList.add(1);
        intList.add(2);
        intList.add(3);
        intList.remove(0);
        Assert.assertEquals((Object)2, intList.get(0));
        Assert.assertEquals((Object)3, intList.get(1));
    }

    @Test
    public void findIndex() {
        charList.add('x');
        charList.add('y');
        charList.add('z');
        Assert.assertEquals(1, charList.indexOf('y'));
        Assert.assertEquals(-1, charList.indexOf('w'));

        intList.add(1);
        intList.add(2);
        Assert.assertEquals(1, intList.indexOf(2));
        Assert.assertEquals(-1, intList.indexOf(3));
    }

    @Test
    public void containsElement() {
        charList.add('a');
        charList.add('b');
        charList.add('c');
        Assert.assertTrue(charList.contains('a'));
        Assert.assertFalse(charList.contains('d'));

        intList.add(1);
        intList.add(2);
        Assert.assertTrue(intList.contains(1));
        Assert.assertFalse(intList.contains(3));
    }




}
