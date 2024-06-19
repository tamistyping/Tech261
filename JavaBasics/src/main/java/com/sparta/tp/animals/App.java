package com.sparta.tp;

public class App {
    public static void main(String[] args){
        Animal dog = new Dog("Max", "Terrier", 1);
        Animal cat = new Cat("Bob", "Bengal", 6);

        Animal[] animals = {dog, cat};

        animals[1].play();

        cat.play();
        dog.play();
        dog.play("Tam");
        dog.eat("Paul");


    }
}
