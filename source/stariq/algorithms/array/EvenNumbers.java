package stariq.algorithms.array;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class EvenNumbers {

    public static void main(String[] args) {
        int[] array = new int[] {1,4,2,6,8,2,3,5,6,9,0};
        printEvenNumbers(array);
    }

    public static void printEvenNumbers(int[] array) {
        List<Integer> list = Arrays.stream(array).boxed().collect(Collectors.toList());
        Iterator<Integer> iterator = list.listIterator();
        while(iterator.hasNext()) {
            int number = iterator.next();
            if(number % 2 == 0) {
                System.out.print(number + " ");
            }
        }
    }
}
