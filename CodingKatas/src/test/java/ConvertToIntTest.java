import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ConvertToIntTest {

    @Test
    @DisplayName("Arr [1, 2, 3] should be converted to 123")
    void testConvertArrToInt1() {
        int[] input = {1, 2, 3};
        int expected = 123;
        int actual = ConvertToInt.convertArrToInt(input);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Arr [0, 2, 3, 5] should be converted to 235")
    void testConvertArrToInt2() {
        int[] input = {0, 2, 3, 5};
        int expected = 235;
        int actual = ConvertToInt.convertArrToInt(input);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Arr [9, 5, 3, 7] should be converted to 9537")
    void testConvertArrToInt3() {
        int[] input = {9, 5, 3, 7};
        int expected = 9537;
        int actual = ConvertToInt.convertArrToInt(input);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Array [-1, 3, 2, 3] should be converted to 1323")
    void testConvertArrToInt4() {
        int[] input = {-1, 3, 2, 3};
        int expected = 1323;
        int actual = ConvertToInt.convertArrToInt(input);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Array [0, 0, 0] should be converted to 0")
    void testConvertArrToInt5() {
        int[] input = {0, 0, 0};
        int expected = 0;
        int actual = ConvertToInt.convertArrToInt(input);
        Assertions.assertEquals(expected, actual);
    }
}