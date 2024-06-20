public class CheckIfPalindrome
{
    public static boolean checkIfPalindrome(String string){
        String x = string.toLowerCase();
        StringBuilder reversed = new StringBuilder(x);
        reversed.reverse();

        if(x.length() < 3){
            return false;
        } else return x.equals(reversed.toString());
    }
}
