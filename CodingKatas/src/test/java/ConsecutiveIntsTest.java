import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ConsecutiveIntsTest {

    @Test
    @DisplayName("Arr [1, 2, 3, 3, 3] should return true")
    void testTrue() {
        int[] input = {1, 2, 3, 3, 3};
        boolean expected = true;
        boolean actual = ConsecutiveInts.checkIfConsecutive(input);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Arr [0, 2, 3, 5, -5, 5] should return false")
    void testFalse() {
        int[] input = {0, 2, 3, 5, -5, 5};
        boolean expected = false;
        boolean actual = ConsecutiveInts.checkIfConsecutive(input);
        Assertions.assertEquals(expected, actual);
    }
}