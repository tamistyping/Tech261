package com.sparta.tp;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ProgramTest {

    @Test //Carries Metadata. Passes this to JVM
    @DisplayName("Given a time of 21, then the greeting should be Good Evening")
    void checkThat21GivesGoodEvening() {
        int time = 21;
        String expectedGreeting = "Good evening!";
        String actualGreeting = Program.getGreeting(time);
        Assertions.assertEquals(expectedGreeting, actualGreeting);
    }

    @Test
    @DisplayName("Given a time of 8, then the greeting should be Good Morning")
    void checkThat8GivesGoodMorning() {
        int time = 8;
        String actualGreeting = Program.getGreeting(time);
        Assertions.assertEquals("Good morning!", actualGreeting);
    }

    @Test
    @DisplayName("Given a time of 8, then the greeting should be Good Afternoon")
    void checkThat13GivesGoodAfternoon() {
        int time = 13;
        String actualGreeting = Program.getGreeting(time);
        Assertions.assertEquals("Good afternoon!", actualGreeting);
    }
}
