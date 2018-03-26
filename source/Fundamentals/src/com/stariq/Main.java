package com.stariq;

import java.util.*;

public class Main {

    public static void main(String[] args) {

    }
}

abstract class Animal{

    private static int idCount = 1;
    private final int id;
    private final String name;

    public Animal(String name){
        this.name = name;
        id = idCount;
        idCount++;
    }

    public int getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    abstract void eat();
    abstract void speak();
}

