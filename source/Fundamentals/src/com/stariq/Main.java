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

interface CanFly{

    void fly();
    void speed();
}

class Dog extends Animal{

    public Dog(String name){
        super(name);
    }

    @Override
    public void eat(){
        System.out.println(getName() + " is chewing");
    }

    @Override
    public void speak(){
        System.out.println(getName() + " is barking");
    }
}

class Pigeon extends Animal implements CanFly{

    public Pigeon(String name){
        super(name);
    }

    @Override
    public void eat(){
        System.out.println(getName() + " is pecking");
    }

    @Override
    public void speak(){
        System.out.println(getName() + " is cooing");
    }

    @Override
    public void fly(){
        System.out.println(getName() + " is flying");
    }

    @Override
    public void speed(){
        System.out.println(getName() + " is speeding");
    }
}




