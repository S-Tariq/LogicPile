package com.stariq;

import java.util.*;

public class Main {

    public static void main(String[] args) {

    }

    public static void animalFunctions() {

        System.out.println("\n*****");

        Dog husky = new Dog("Husky");
        Dog yorkie = new Dog("Yorkie");
        Pigeon barb = new Pigeon("Barb");

        List<Animal> animals = new ArrayList<Animal>();
        animals.add(husky);
        animals.add(yorkie);
        animals.add(barb);

        for (Animal animal : animals) {
            System.out.println("Animal Id: " + animal.getId());
            animal.speak();
            animal.eat();
        }
    }

    public static void flyFunctions(){

        System.out.println("\n*****");

        Pigeon carrier = new Pigeon("Carrier");
        Plane plane = new Plane();

        List<CanFly> canFlies = new ArrayList<CanFly>();
        canFlies.add(carrier);
        canFlies.add(plane);

        for(CanFly canFly : canFlies){
            canFly.fly();
            canFly.speed();
        }
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

class Plane implements CanFly{

    @Override
    public void fly(){
        System.out.println("Plane is flying");
    }

    @Override
    public void speed(){
        System.out.println("Plane is speeding");
    }
}


