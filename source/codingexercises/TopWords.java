package codingexercises;

import java.io.*;
import java.util.*;

public class TopWords {

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
            System.out.println("'" + topWord + "'" + " which has the frequency of: " + maxFreqNum);
            frequency.remove(topWord);
            maxFreqNum = 0;
            topWord = null;
        }
    }
}