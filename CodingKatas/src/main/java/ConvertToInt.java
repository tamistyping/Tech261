import java.util.Arrays;
import java.util.logging.Logger;

public class ConvertToInt {

    private static final Logger LOGGER = Logger.getLogger(ConvertToInt.class.getName());

    public static int convertArrToInt(int[] arr) {

        LOGGER.info("arr input: " + Arrays.toString(arr));

        StringBuilder result = new StringBuilder();

        for (int number : arr) {
            LOGGER.info("Appending number: " + number);
            result.append(Math.abs(number));
        }

        LOGGER.info("Concatenated string: " + result);
        return Integer.parseInt(String.valueOf(result));
    }

    public static void main(String[] args) {
        int[] arr = {1, 24, 1, 0};
        System.out.println(convertArrToInt(arr));
    }
}
