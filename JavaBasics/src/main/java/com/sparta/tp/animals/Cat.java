package com.sparta.tp.animals;

public class Cat extends Animal{
    public Cat(String name, String breed, int age) {
        super(name, breed, age);
    }

    @Override
    public void play(String name) {
        System.out.println(super.getName() + " does not want to play");
    }

    @Override
    public void eat(String name) {
        System.out.println(name + " wants to eat with " + super.getName());
    }

    public void climb(){
        System.out.println("Cat is climbing");
    }
}