package com.sparta.tp;

import org.hamcrest.Matcher;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class HamcrestExample {
    private Spartan tam;

    @BeforeEach
    void setup() {
        tam = new Spartan(1, "Tam", "Java", LocalDate.of(2000, 1, 1));
    }
    @Nested
    @DisplayName("Hamcrest Spartan Tests")
    class hamcrestSpartanTests{
        @Test
        @DisplayName("Check That Spartan Is Called Tam")
        void checkThatSpartanIsCalledTam() {
            assertThat(tam.getName(), equalTo("Tam"));//fluent API - methodology of
            // writing your code as close to// 'human english' as possible
        }

        @Test
        @DisplayName("Check That Spartan has a field called name")
        void checkThatSpartanHasAFieldCalledName() {
            assertThat(tam, hasProperty("name"));
        }

        @Test
        @DisplayName("Check That Spartan has a field called course")
        void checkThatSpartanHasAFieldCalledCourseSetToJava() {
            assertThat(tam, hasProperty("course", equalTo("Java")));
        }

        @Test
        @DisplayName("Check that Spartan's course date is before today's date")
        void checkCourseDateBeforeToday() {
            LocalDate today = LocalDate.now();
            assertThat(tam.getStartDate(), lessThanOrEqualTo(today));
        }
    }

    @Nested
    @DisplayName("Hamcrest string methods")
    class HamcrestStringMethods{
        @Test
        @DisplayName("Check that name is not empty or null")
        void checkThatNameIsNotEmpty() {
            assertThat(tam.getName(), is(not(emptyOrNullString())));
        }

        @Test
        @DisplayName("Check that name ends with am")
        void checkThatNameEndsWithAm() {
            assertThat(tam.getName(), endsWith("am"));
        }

        @Test
        @DisplayName("Check that name starts with T")
        void checkThatNameStartsWithT() {
            assertThat(tam.getName(), startsWith("T"));
        }

    }
}
