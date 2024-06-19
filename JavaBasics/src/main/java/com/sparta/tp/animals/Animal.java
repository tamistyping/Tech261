package com.sparta.tp.animals;

public abstract class Animal {
    private final String name;
    private String breed;
    private int age;

    public Animal(String name, String breed, int age) {
        this.name = name;
        this.breed = breed;
        this.age = age;
    }

    public String getName(){
        return name;
    }

    public void setBreed(String breed){
        this.breed = breed;
    }

    public int getAge(){
        return age;
    }

    public void setAge(int age){
        this.age = age;
    }

    public void play(){
        System.out.println(name + " wants to play");
    }

    public void eat(){
        System.out.println("animal is eating"); //everyone is overriding
    }

    //name has to be the same
    //1. return type
    //2. type of parameters
    //3. order parameters
    public abstract void play(String name);

    public abstract void eat(String name);
}
