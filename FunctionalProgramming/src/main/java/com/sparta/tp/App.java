package com.sparta.tp;

public class App {
    public static void main(String[] args) {
        SwitchOnable switchOnable = () -> System.out.println("Switch on");


        switchOnable.switchOn();
        System.out.println(switchOnable.getClass());
    }
}
