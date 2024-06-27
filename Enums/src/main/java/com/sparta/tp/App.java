package com.sparta.tp;

public class App {
    public static void main(String[] args) {
        for (Potion potion : Potion.values()){
            System.out.println("Potion: "+potion.getName());
            System.out.println("Effect: "+potion.getDescription());
            System.out.println("Duration: "+potion.getDuration() + " seconds");
            System.out.println("\n");
        }
    }
}



