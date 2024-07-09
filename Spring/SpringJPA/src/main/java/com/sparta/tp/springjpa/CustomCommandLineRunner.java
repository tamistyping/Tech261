package com.sparta.tp.springjpa;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
//this class is now marked as a component
//spring will now figure out how to build from this
public class CustomCommandLineRunner implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        System.out.println("Hello from CustomCommandLineRunner");
    }
}
