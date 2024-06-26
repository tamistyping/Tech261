package com.sparta.tp;

// ***** FEATURES *****
// - Allows null value
// - It is a non-synchronised class
// - It stores the elements using the hashing mechanism
// - Most useful in the search operations
// - Only contains unique elements

import java.util.HashSet;

public class App {
    public static void main(String[] args) {

        HashSet<String> animals = new HashSet<>();

        animals.add("Gorilla");
        animals.add("Lion");
        animals.add("Macaw");

        for (String animal : animals) {
            System.out.println(animal);
        }

//        System.out.println("\n" + animals.contains("Lion"));
    }
}


