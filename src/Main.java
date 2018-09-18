import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

public class Main {

    /**
     * Retrieve contents from a URL and return them as a string.
     *
     * @param url url to retrieve contents from
     * @return the contents from the url as a string, or an empty string on error
     */
    public static String urlToString(final String url) {
        Scanner urlScanner;
        try {
            urlScanner = new Scanner(new URL(url).openStream(), "UTF-8");
        } catch (IOException e) {
            return "";
        }
        String contents = urlScanner.useDelimiter("\\A").next();
        urlScanner.close();
        return contents;
    }

    public static double wordCount(final String words) {

        char[] letters = words.toCharArray();
        double total = 0;
        boolean previousIsSpace = false;
        for (int i = 0; i < letters.length; i++) {
            if (letters[i] == ' ') {
                if (previousIsSpace == false) {
                    total++;
                    previousIsSpace = true;
                }
            } else if (previousIsSpace == true) {
                previousIsSpace = false;
            }
        }
        return total;

    }

    public static double wordAppearances(final String text, final String word) {

        char[] lettersInText = text.toCharArray();
        char[] lettersInWord = word.toCharArray();
        double total = 0;
        for (int i = 0; i < lettersInText.length; i++) {
            if(lettersInText[i] == lettersInWord[0]) {
                int correctLetters = 1;
                for (int j = 1; j < lettersInWord.length; j++) {
                    i++;
                    if (lettersInText[i] == lettersInWord[j]) {
                        correctLetters++;
                    }
                }
                if (correctLetters == lettersInWord.length) {
                    total++;
                }
            }
        }
        return total;
    }

    public static void main(String[] args) {

        System.out.println(wordAppearances(urlToString("http://erdani.com/tdpl/hamlet.txt"), "prince"));

    }
}
