public class ConvertToInt {
    public static int convertArrToInt(int[] arr) {
        StringBuilder result = new StringBuilder();
        for (int number : arr) {
            result.append(Math.abs(number));
        }
        return Integer.parseInt(String.valueOf(result));
    }
}
