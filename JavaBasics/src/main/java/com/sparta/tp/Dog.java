package com.sparta.tp;

public class Dog {
    private String name;
    private String breed;
    private int age;

    public Dog(String name, String breed, int age) {
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

    public static void main(String[] args){
        //int age = 5
        Dog max = new Dog("Max", "Terrier", 2);
        Dog fido = new Dog("Fido", "Labrador", 1);
        System.out.println(max.getName());
        System.out.println(fido.getName());
    }
}
