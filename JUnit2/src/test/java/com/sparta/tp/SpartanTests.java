package com.sparta.tp;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import java.util.stream.Stream;

public class SpartanTests {

    @Test
    @Disabled("Waiting for method to be completed")
    @DisplayName("Check name of Spartan")
    public void checkNameOfSpartan() {
        // Replace this with actual test logic
        String spartanName = "Leonidas"; // Replace with actual name from your application
        Assertions.assertEquals("Leonidas", spartanName, "Spartan name should be Leonidas");
    }

    @BeforeAll //can be used to instantiate variables too
    static void setupAll(TestInfo testInfo){

    }

    @BeforeEach
    void setup(){

    }

    @AfterEach
    void tearDown(){

    }

    @AfterAll
    static void tearDownAll(){

    }

    @ParameterizedTest
    @NullAndEmptySource
    @MethodSource("getListOfNames")
    void checkLengthOfString(String names){
        Assertions.assertEquals(5, names.length());
    }

    public static Stream<Arguments> getListOfNames() {
        return Stream.of(
                Arguments.of("Manish"),
                Arguments.of("Alex")
        );
    }


}