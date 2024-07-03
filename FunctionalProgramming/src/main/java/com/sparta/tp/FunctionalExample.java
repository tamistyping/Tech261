package com.sparta.tp;

import java.util.ArrayList;
import java.util.Arrays;

public class FunctionalExample {
    public static void main(String[] args) {
        //Something  ->  Stream -> "Real"

        ArrayList<String> names = new ArrayList<>(Arrays.asList(
                "Leonardo",
                "Michelangelo",
                "Donatello",
                "Raphael"
        ));

        names.stream()
                .map(String::toUpperCase)
//                .filter(name -> name.contains("O"))
                .forEach(System.out::println);
    }
}
