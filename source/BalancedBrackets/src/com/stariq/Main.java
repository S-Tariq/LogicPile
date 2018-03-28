package com.stariq;

public class Main {

    public static void main(String[] args) {
        addBrackets();
    }

    public static void addBrackets(){

        BalancedBrackets input = new BalancedBrackets();
        boolean isValid = input.exec("{[]}");
        if (isValid) {
            System.out.println("String is valid");
        } else {
            System.out.println("String is invalid");
        }
    }
}
