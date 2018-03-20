package com.stariq;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException{
        TopWords topWords = new TopWords();
        topWords.findTopWords("C:\\Users\\User\\Documents\\Projects\\IntelliJ IDEA\\LogicPile\\source\\TopWords\\Words.txt");
    }
}
