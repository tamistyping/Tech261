package com.sparta.tp.factory;

public class AnimalFactory {
    public static Speakable getAnimal(String animal) {
        return switch (animal) {
            case "Cow" -> new Cow();
            case "Cat" -> new Cat();
            case "Goldfish" -> new Goldfish();
            default -> null;
        };
    }
}
