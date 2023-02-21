package com.epam.rd.autotasks.words;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtil {
    public static int countEqualIgnoreCaseAndSpaces(String[] words, String sample) {
        int count = 0;
        if (sample == null || words == null) {
            return count;
        }
        for(String word : words) {
            if (Pattern.matches( ("\\p{Blank}*"+sample.toLowerCase().strip() + "\\p{Blank}*"), word.toLowerCase())) {
                count++;
            }
        }
        return count;
    }


    public static String[] splitWords(String text) {
        if (text == null ||text.isBlank()) {
            return null;
        }

        Pattern pattern = Pattern.compile("[, . : ; ? !]");
        String[] words = pattern.split(text);
        int count = 0;
        for(String word : words) {
            if (word.isEmpty() == false) {
                count++;
            }
        }

        String[] words2 = new  String[count];
        int i = 0;

        for(String word : words) {
            if(word.isEmpty() == false) {
                words2[i] = word;
                i++;
            }
        }
        if(i == 0) {
            return null;
        }

        return words2;
    }


    public static String convertPath(String path, boolean toWin) {
        if(path == null || path.isEmpty() ) {
            return null;
        }
        Pattern patternSlash = Pattern.compile("/");
        Pattern patternReversSlash = Pattern.compile("\\\\");

        String patternUnix ="~?(\\.\\.)?/?([a-zA-Z_]+\\/)*(\\.\\.\\/)*([a-zA-Z_]+\\\\/)*(([a-zA-Z_]+\\.[a-zA-Z_]+)|([a-zA-Z_ ]+))?";
        String patternWindows = "((C:\\\\)|\\\\|(\\.\\\\)|\\.|(\\.\\.\\\\))?([a-zA-Z_]+\\\\)*(\\.\\.\\\\)*([a-zA-Z_]+\\\\)*(([a-zA-Z_]+\\.[a-zA-Z]+)*|([a-zA-Z_ ]+))?"; //pattern for Windows

        if(Pattern.matches(patternUnix, path) == false  &&  Pattern.matches(patternWindows, path) == false) {
            return null;
        }

        if (toWin == true &&( path.contains("/")|| path.contains("~"))) { // unix to win
            Matcher m = patternSlash.matcher(path);
            path = m.replaceAll("\\\\");
            StringBuilder stringBuilder = new StringBuilder(path);

            if(path.contains("~")) {
                stringBuilder.delete(0, 1);
                stringBuilder.insert(0, "C:\\User");
            } else if (path.charAt(0)== '\\'){

                stringBuilder.insert(0, "C:");
            }
            path = stringBuilder.toString();

        }else if (toWin == false && path.contains("\\")) { //  win unix
            Matcher m = patternReversSlash.matcher(path);
            path = m.replaceAll("/");
            StringBuilder stringBuilder = new StringBuilder(path);

            if(path.contains("C:/User")) {
                stringBuilder.delete(0, 7);
                stringBuilder.insert(0, "~");
            }else if(path.contains("C:/")) {
                stringBuilder.delete(0, 2);
            }

            path = stringBuilder.toString();
        }

        return path;
    }

    public static String joinWords(String[] words) {
        if(words == null) {
            return null;
        }

        StringBuilder stringBuilder = new StringBuilder();

        for(String word : words) {
            if(word.isEmpty() == false && word.isBlank() == false) {
                stringBuilder.append(word + ", ");
            }
        }
        if(stringBuilder.toString().isBlank()) {
            return null;
        }
        stringBuilder.delete(stringBuilder.length()-2, stringBuilder.length());
        stringBuilder.insert(0, "[").insert(stringBuilder.length(), "]");

        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        System.out.println("Test 1: countEqualIgnoreCaseAndSpaces");
        String[] words = new String[]{" WordS    \t", "words", "w0rds", "WOR  DS", };
        String sample = "words   ";
        int countResult = countEqualIgnoreCaseAndSpaces(words, sample);
        System.out.println("Result: " + countResult);
        int expectedCount = 2;
        System.out.println("Must be: " + expectedCount);

        System.out.println("Test 2: splitWords");
        String text = "   ,, first, second!!!! third";
        String[] splitResult = splitWords(text);
        System.out.println("Result : " + Arrays.toString(splitResult));
        String[] expectedSplit = new String[]{"first", "second", "third"};
        System.out.println("Must be: " + Arrays.toString(expectedSplit));

        System.out.println("Test 3: convertPath");
        String unixPath = "/some/unix/path";
        String convertResult = convertPath(unixPath, true);
        System.out.println("Result: " + convertResult);
        String expectedWinPath = "C:\\some\\unix\\path";
        System.out.println("Must be: " + expectedWinPath);

        System.out.println("Test 4: joinWords");
        String[] toJoin = new String[]{"go", "with", "the", "", "FLOW"};
        String joinResult = joinWords(toJoin);
        System.out.println("Result: " + joinResult);
        String expectedJoin = "[go, with, the, FLOW]";
        System.out.println("Must be: " + expectedJoin);
    }
}

