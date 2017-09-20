
import java.io.IOException;
import java.net.URL;
import java.util.Scanner;
/**
 * @author yathannshkulshrestha
 *
 */


public class Rt {


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

    /**
     * Retrieve contents from a URL and return them as a string.
     *
     * @param s url to retrieve contents from
     * @return the contents from the url as a string, or an empty string on error
     */
    public static int countWords(final String s) {

        int wordCount = 0;

        boolean word = false;
        int endOfLine = s.length() - 1;

        for (int i = 0; i < s.length(); i++) {
            // if the char is a letter, word = true.
            if (Character.isLetter(s.charAt(i)) && i != endOfLine) {
                word = true;
                // if char isn't a letter and there have been letters before,
                // counter goes up.
            } else if (!Character.isLetter(s.charAt(i)) && word) {
                wordCount++;
                word = false;
                // last word of String; if it doesn't end with a non letter, it
                // wouldn't count without this.
            } else if (Character.isLetter(s.charAt(i)) && i == endOfLine) {
                wordCount++;
            }
        }
        return wordCount;
    }



    /**
     * @param args clomw omw
     */
    public static void main(final String[] args) {
        // TODO Auto-generated method stub
        String para = urlToString("http://erdani.com/tdpl/hamlet.txt");
        String hii = urlToString("http://erdani.com/tdpl/hamlet.txt");
        int wcount = countWords(para);
        System.out.println(para);
        System.out.println("Word Count:" + wcount);

        String str = para;
        String findStr = "Peal";
        int lastIndex = 0;
        int count = 0;

        while (lastIndex != -1) {

            lastIndex = str.indexOf(findStr, lastIndex);

            if (lastIndex != -1) {
                count++;
                lastIndex += findStr.length();
            }
        }
        System.out.println(count);
        final String input = hii;
        final char   token = '#';
        String processedInput  = "";
        String currentWord     = "";
        int    wordCount       = 0;
        int    uniqueWordCount = 0;

        for (char c : input.toCharArray()) {
            if (c != ' ') {
                processedInput += c;
                currentWord    += c;
            } else {
                processedInput += token;
                wordCount++;

                String  existingWord      = "";
                int     occurences        = 0;

                for (char c1 : processedInput.toCharArray()) {
                    if (c1 != token) {
                        existingWord += c1;
                    } else {
                        if (existingWord.equals(currentWord)) {

                            occurences++;
                        }

                        existingWord = "";
                    }
                }

                if (occurences <= 1) {

                    uniqueWordCount++;
                }

                currentWord = "";
            }
        }
        wordCount++;


        System.out.printf("%d words total, %d unique\n", wordCount, uniqueWordCount);


    }
    }


