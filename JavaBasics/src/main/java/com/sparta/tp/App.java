package com.sparta.tp;

public class App {
    public static void main(String[] args){
        Dog dog = new Dog("Max", "Terrier", 1);
        Cat cat = new Cat("Bob", "Bengal", 6);

        cat.play();
        dog.play();
        dog.play("Tam");
    }
}
