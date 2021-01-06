package stariq.algorithms.sort;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class TopWordsUsingComparator {

    public static void main(String[] args) throws IOException {
        // PC
        //findTopWords("D:\\Media\\Projects\\GitHub\\LogicPile\\data\\Words.txt");
        // Laptop
        findTopWords("C:\\Users\\samee\\Documents\\GitHub\\LogicPile\\data\\Words.txt");
    }

    public static void findTopWords(String path) throws IOException {
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        List<String> list = new ArrayList<>();

        BufferedReader reader = new BufferedReader(new FileReader(path));
        String line = reader.readLine();
        while (line != null) {
            String[] words = line.split(" ");
            for (String word : words) {
                word = word.toLowerCase().replace(",", "")
                        .replace(".","");
                map.put(word, map.getOrDefault(word, 0) + 1);
                if(!list.contains(word)) {
                    list.add(word);
                }
            }
            line = reader.readLine();
        }

        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                int freqComp = Integer.compare(map.get(b), map.get(a));
                int stringComp = a.compareTo(b);
                if(freqComp == 0) {
                    return stringComp;
                } else {
                    return freqComp;
                }
            }
        });

        // Top words
        int top = 10;
        list = list.subList(0,top);

        for(String s : list) {
            System.out.println(s + ": " + map.get(s));
        }
    }
}
