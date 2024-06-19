package com.sparta.tp;

public class Dog extends Animal implements Drinkable{

    public Dog(String name, String breed, int age) {
        super(name, breed, age);
    }

    //name has to be the same
    //1. return type
    //2. type of parameters
    //3. order parameters
    @Override
    public void play(String name) {
        System.out.println(name + " wants to play with " + super.getName());
    }

    @Override
    public void eat(String name){
        System.out.println(name + " wants to eat with " + super.getName());
    }

    @Override
    public void drink() {
        System.out.println("Drinking water");
    }
}
