package com.stariq;

public class Main {

    public static void main(String[] args) {

        BracketsInput input = new BracketsInput();
        boolean isValid = input.correctParenthensies("{[]}");
        System.out.println(isValid);

        if (isValid) {
            System.out.println("String is valid");
        } else {
            System.out.println("String is invalid");
        }
    }
}

