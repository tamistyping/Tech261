package com.sparta.tp;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class FizzBuzzTests {
    // Print numbers in order
    // If the number is divisible by 3, print "Fizz"
    // If the number is divisible by 5, print "Buzz"
    // If it's divisible by both, print "FizzBuzz"

    @Test
    @DisplayName("Given an input of 1, returns 1")
    void givenAnInputOfOneFizzBuzzReturnsOne() {
        //Arrange
        int input = 1;
        String expected = "1";

        //Act
        String actual = FizzBuzz.getFizzBuzzFrom(input);

        //Assert
        Assertions.assertEquals(expected, actual);
    }

    @ParameterizedTest
    @DisplayName("Given an input is not divisible by 3 or 5 returns that number")
    @CsvSource({"2, 2", "4, 4", "7, 7"})
    void givenInputsNotDivisibleByThreeOrFiveReturnsThatNumber(int input, String expected) {
        String actual = FizzBuzz.getFizzBuzzFrom(input);

        Assertions.assertEquals(expected, actual);
    }

    @ParameterizedTest
    @DisplayName("Given a multiple of 5 returns Buzz")
    @CsvSource({"5, Buzz", "10, Buzz", "25, Buzz"})
    void givenAMultipleOfFiveReturnsBuzz(int input, String expected) {
        String actual = FizzBuzz.getFizzBuzzFrom(input);

        Assertions.assertEquals(expected, actual);
    }

    @ParameterizedTest
    @DisplayName("Given a multiple of 5 and 3 returns FizzBuzz")
    @CsvSource({"15, FizzBuzz", "30, FizzBuzz", "90, FizzBuzz"})
    void givenAMultipleOfFiveAndThreeReturnsFizzBuzz(int input, String expected) {
        String actual = FizzBuzz.getFizzBuzzFrom(input);

        Assertions.assertEquals(expected, actual);
    }

    @ParameterizedTest
    @DisplayName("Given a multiple 3 returns Fizz")
    @ValueSource(ints = {3, 6, 9})
    void givenAnInputOfThreeFizzBuzzReturnsFizz(int input) {
        String expected = "Fizz";

        String actual = FizzBuzz.getFizzBuzzFrom(input);

        Assertions.assertEquals(expected, actual);
    }
}
