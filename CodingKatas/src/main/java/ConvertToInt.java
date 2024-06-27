import java.io.IOException;
import java.util.Arrays;
import java.util.logging.*;

public class ConvertToInt {

    private static final Logger LOGGER = Logger.getLogger(ConvertToInt.class.getName());

    public static void main(String[] args) {
        setUpLogging();

        int[] arr = {1, 24, 1, 0};
        System.out.println(convertArrToInt(arr));
    }

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

    private static void setUpLogging(){
        ConsoleHandler consoleHandler = new ConsoleHandler();
        consoleHandler.setLevel(Level.ALL);
        LOGGER.addHandler(consoleHandler);

        try{
            FileHandler fileHandler = new FileHandler("log-file.log", false);
            fileHandler.setLevel(Level.ALL);
            fileHandler.setFormatter(new SimpleFormatter());
            LOGGER.addHandler(fileHandler);
        } catch (IOException e){
            throw new RuntimeException("Failed to run log file handler", e);
        }
    }
}
