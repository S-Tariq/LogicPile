package stariq.datastructures.hashmap;

import java.util.Arrays;

public class HashTableRough {

    public static void main(String[] args) {

        HashTableRough ht = new HashTableRough(30);

        String[] elements = {"1", "5", "17", "21", "26"};

        ht.hashFunction1(elements, ht.theArray);

        ht.displayTheHashTable();

    }

    String[] theArray;
    int arraySize;
    int itemsInArray;

    HashTableRough(int size) {
        this.arraySize = size;
        theArray = new String[size];
        Arrays.fill(theArray, "-1");
    }

    // Puts values in the same index that matches their value.
    public void hashFunction1(String[] stringsArray, String[] theArray) {
        for(int i = 0; i < stringsArray.length; i++) {
            String element = stringsArray[i];
            theArray[Integer.parseInt(element)] = element;
        }
    }

    public void hashFunction2(String[] stringsArray, String[] theArray) {

    }

    public void displayTheHashTable() {
        int increment = 0;
        for (int m = 0; m < 3; m++) {
            increment += 10;
            for (int n = 0; n < 71; n++) {
                System.out.print("-");
            }
            System.out.println();
            for (int n = increment - 10; n < increment; n++) {
                System.out.format("| %3s " + " ", n);
            }
            System.out.println("|");
            for (int n = 0; n < 71; n++) {
                System.out.print("-");
            }
            System.out.println();
            for (int n = increment - 10; n < increment; n++) {
                if (theArray[n].equals("-1")) {
                    System.out.print("|      ");
                } else {
                    System.out.print(String.format("| %3s " + " ", theArray[n]));
                }
            }
            System.out.println("|");
            for (int n = 0; n < 71; n++) {
                System.out.print("-");
            }
            System.out.println();
        }
    }

}
