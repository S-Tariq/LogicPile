package stariq.algorithms.sort;

import java.io.*;
import java.util.*;

// Finds the top five words in a text file.
// Uses a map to store all the unique words as keys and their frequency as values.
// Loops through the lines of text to find the top five keys and their corresponding values.

public class TopWordsUsingMax {

    public static void main(String[] args) throws IOException{
        // PC
        //findTopWords("D:\\Media\\Projects\\GitHub\\LogicPile\\data\\Words.txt");
        // Laptop
        findTopWords("C:\\Users\\samee\\Documents\\GitHub\\LogicPile\\data\\Words.txt");
    }

    public static void findTopWords(String path) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(path));
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        String line = reader.readLine();
        while (line != null) {
            if (!line.trim().equals("")) {
                String[] words = line.split(" ");
                for (String word : words) {
                    String processed = word.toLowerCase();
                    processed = processed.replace(",", "");
                    processed = processed.replace(".", "");
                    if (map.containsKey(processed)) {
                        map.put(processed, map.get(processed) + 1);
                    } else {
                        map.put(processed, 1);
                    }
                }
            }
            line = reader.readLine();
        }
        String topWord = null;
        int maxFreqNum = 0;
        int freqNum;
        int maxNumber = 5;
        System.out.println("The most common " + maxNumber + " words are: ");
        for (int i = 0; i < maxNumber; i++) {
            for (String word : map.keySet()) {
                freqNum = map.get(word);
                if (freqNum > maxFreqNum) {
                    topWord = word;
                    maxFreqNum = freqNum;
                }
            }
            System.out.println("'" + topWord + "'" + " with frequency of: " + maxFreqNum);
            map.remove(topWord);
            maxFreqNum = 0;
            topWord = null;
        }
    }
}