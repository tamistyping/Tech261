package com.sparta.mg;

public class App {
    public static void main(String[] args) {
        String string1 = "Hello";
        String string2 = "Hello";
        String string3 = new String("Hello");
        String string4 = new String("Hello");

        System.out.println(string1.hashCode());
        System.out.println(string2.hashCode());
        System.out.println(string3.hashCode());
        System.out.println(string4.hashCode());
        System.out.println("");
        System.out.println(string1 == string2);
        System.out.println("");
        System.out.println(System.identityHashCode(string1));
        System.out.println(System.identityHashCode(string2));
        System.out.println(System.identityHashCode(string3));
        System.out.println(System.identityHashCode(string4));
    }
}
