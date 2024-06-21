import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CheckIfPalindromeTest {
    @Test
    @DisplayName("If the word is less than 3 characters long, test should fail")
    void checkIfWordIsMoreThan3CharLong(){
        String input = "pa";
        boolean expected = false;
        boolean actual = CheckIfPalindrome.checkIfPalindrome(input);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("String 'hello' should return false")
    void checkIfWordIsPalindromeFalse(){
        String input = "hello";
        boolean expected = false;
        boolean actual = CheckIfPalindrome.checkIfPalindrome(input);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("String 'radar' should return true")
    void checkIfWordIsPalindromeTrue(){
        String input = "radar";
        boolean expected = true;
        boolean actual = CheckIfPalindrome.checkIfPalindrome(input);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("String 'raDAR' should return true")
    void checkIfCapitalEffectsTrue() {
        String input = "raDAR";
        boolean expected = true;
        boolean actual = CheckIfPalindrome.checkIfPalindrome(input);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("String 'rada r' should return false")
    void spacesShouldNotBeIgnored() {
        String input = "rada r";
        boolean expected = false;
        boolean actual = CheckIfPalindrome.checkIfPalindrome(input);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Test longest Palindrome in string")
    void longestPalindromeInString() {
        String input = "hello its tam and i got caught by a radar in my racecar";
        String expected = "racecar";
        String actual = CheckIfPalindrome.getLongestPalindromes(input);
        Assertions.assertEquals(expected, actual);
    }
}
