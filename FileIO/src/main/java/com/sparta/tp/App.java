package com.sparta.tp;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class App {
    public static void main(String[] args) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("src/main/resources/employees-corrupted.csv"))){
            bufferedReader.readLine();
        } catch (IOException e) {
            System.out.println(e);
        } finally {
            System.out.println("In Finally block");
        }
    }
}
