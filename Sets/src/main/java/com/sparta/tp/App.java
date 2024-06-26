package com.sparta.tp;
import java.util.HashSet;

public class App {
    public static void main(String[] args) {

        HashSet<Animal> animals = new HashSet<>();

        Animal snake = new Animal("Snake");
        Animal macaw = new Animal("Macaw");

        //add method (show behind scenes of add method)
        animals.add(snake);
        animals.add(macaw);

        //java automatically calls the tostring method of each animal object to display its objects.
        System.out.println("Animals in HashSet: " + animals);
    }
}
