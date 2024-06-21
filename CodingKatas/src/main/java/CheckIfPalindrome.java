public class CheckIfPalindrome {
    public static boolean checkIfPalindrome(String string) {
        String x = string.toLowerCase();
        StringBuilder reversed = new StringBuilder(x);
        reversed.reverse();

        //sort it in large to big

        if (x.length() < 3) {
            return false;
        } else return x.equals(reversed.toString());
    }

    public static boolean isWordPalindrome(String wordToCheck) {
        if (wordToCheck == null || wordToCheck.length() < 3) {
            return false;
        }
        StringBuilder reversedWord = new StringBuilder(wordToCheck.toLowerCase());
        reversedWord.reverse();
        return reversedWord.toString().equals(wordToCheck.toLowerCase());
    }

    public static String getLongestPalindromes(String sentenceToCheck) {
        sentenceToCheck = sentenceToCheck.replaceAll("[^a-zA-Z ]", "").toLowerCase();
        String[] wordsInSentence = sentenceToCheck.split(" ");
        int palindromeLength = 0;
        StringBuilder longestPalindromes = new StringBuilder("None");
        for (String word : wordsInSentence) {
            if (isWordPalindrome(word)) {
                if (word.length() > palindromeLength) {
                    palindromeLength = word.length();
                    longestPalindromes.delete(0, longestPalindromes.length()).append(word);
                } else if (word.length() == palindromeLength && longestPalindromes.indexOf(word) == -1) {
                    longestPalindromes.append(" and ").append(word);
                }
            }
        }
        return longestPalindromes.toString();
    }
}
