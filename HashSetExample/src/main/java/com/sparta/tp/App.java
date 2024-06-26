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

        System.out.println("\nAnimal HashSet: ");
        animals.add("Gorilla");
        animals.add("Lion");
        animals.add("Macaw");
        animals.add("Crocodile");
        animals.add("Dog");



        for (String animal : animals) {
            System.out.println(animal);
        }

        HashSet<String> clonedAnimals = (HashSet<String>) animals.clone();
        System.out.println("\nCloned Animal HashSet: ");
        for (String animal : clonedAnimals) {
            System.out.println(animal);
        }
        animals.remove("Lion");
        System.out.println("\n" + animals.contains("Lion"));
    }
}


