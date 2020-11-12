package stariq.datastructures;

import stariq.older.ArrayList;

import java.util.Arrays;

public class OldArrayListTest {

    public static void main(String[] args) {

        ArrayList customArrayList = new ArrayList(1,2,3);
        System.out.println(Arrays.toString(customArrayList.getArray()));

        customArrayList.addElements(4,5,6);
        System.out.println(Arrays.toString(customArrayList.getArray()));

        customArrayList.addElements(7,8,9);
        System.out.println(Arrays.toString(customArrayList.getArray()));

        //System.out.println(customArrayList.getElement(12));
        try{
            customArrayList.getElement(12);
        } catch (IllegalArgumentException exp) {
            System.out.println("Wrong index");
        }

    }
}
