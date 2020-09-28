package stariq.algorithms;

import java.io.*;
import java.util.*;

// Finding the top five words in a text file.
// Using a map to store all the unique words as keys and their frequency as values.
// Looping through the lines of text to find the top five values and their corresponding keys.

public class TopWords {

    public static void main(String[] args) throws IOException{
        TopWords.findTopWords("D:\\Media\\Projects\\GitHub\\LogicPile\\data\\Words.txt");
    }

    public static void findTopWords(String path) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(path));
        HashMap<String, Integer> frequency = new HashMap<String, Integer>();
        String line = reader.readLine();
        while (line != null) {
            if (!line.trim().equals("")) {
                String[] words = line.split(" ");
                for (String word : words) {
                    String processed = word.toLowerCase();
                    processed = processed.replace(",", "");
                    if (frequency.containsKey(processed)) {
                        frequency.put(processed, frequency.get(processed) + 1);
                    } else {
                        frequency.put(processed, 1);
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
            for (String word : frequency.keySet()) {
                freqNum = frequency.get(word);
                if (freqNum > maxFreqNum) {
                    topWord = word;
                    maxFreqNum = freqNum;
                }
            }
            System.out.println("'" + topWord + "'" + " with frequency of: " + maxFreqNum);
            frequency.remove(topWord);
            maxFreqNum = 0;
            topWord = null;
        }
    }
}