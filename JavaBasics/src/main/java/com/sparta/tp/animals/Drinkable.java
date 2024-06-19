package com.sparta.tp.animals;

public interface Drinkable {
    void drink();
    default void print() {
        printFromInterface();
    }

    private static void printFromInterface(){
        System.out.println("I am printing from an interface");
    }
}

// what are the types of methods i can have an interface. private, static, default
