package com.mathan.gopal;

import java.io.FileReader;
import java.util.ArrayList;

public class DataRetreiver {

    private static String destination = "Subtitles/";

    public static boolean isInteger(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException ex) {
        }
        return false;
    }

    public static TextClass retreiveData(TextClass textClass, String fileName, int escapeChar) throws Exception {
        ArrayList<String> verseNumbers = new ArrayList<String>();
        ArrayList<String> givenText = new ArrayList<String>();
        textClass.name = fileName;

        String dummy = "", text = "";
        int step = 0, i;

        FileReader fr = new FileReader(destination + fileName + ".srt"); // I to VIII
        while ((i = fr.read()) != -1) {
            // System.out.println((char) i+" ascii = "+(int) (char) i);

            if ((int) (char) i == escapeChar) {
                dummy = dummy.trim();
                if (isInteger(dummy)) {
                    // textClass.lineNumber.add(dummy);
                    if (text != null && !text.isEmpty()) {
                        /*
                         * if (text.contains(".")) { textClass.givenText.add(text); text = ""; } else {
                         * }
                         */

                        givenText.add(text);
                        text = "";

                    }
                    step = 1;
                } else if (step == 1) {
                    // System.out.println(dummy);
                    String verseNumber = ""
                            + ((Integer.parseInt(dummy.split(" to ")[0].split(",")[0].split(":")[0]) * 60)
                            + Integer.parseInt(dummy.split(" to ")[0].split(",")[0].split(":")[1]))
                            + ":" + Integer.parseInt(dummy.split(" to ")[0].split(",")[0].split(":")[2]);
                    verseNumbers.add(verseNumber);
                    step = 2;
                } else if (step == 2) {
                    if (text != null && !text.isEmpty()) {
                        text = text + " " + dummy;
                    } else {
                        text = text + dummy;
                    }
                }
                dummy = "";
            } else {
                dummy = dummy + (char) i;
            }

        }
        givenText.add(text);
        fr.close();

        int flag = 0;
        String initialText = givenText.get(0);
        String initialVerseNumber = verseNumbers.get(0);
        for (int k = 1; k < givenText.size(); k++) {
            if (initialText.contains(" ")) {
                if (initialText.contains(".")) {
                    textClass.givenText.add(initialText);
                    textClass.verseNumbers.add(initialVerseNumber);
                    initialText = "";
                    flag = 0;
                } else {
                    flag = 1;
                    initialText = initialText + " " + givenText.get(k);

                }
            } else {
                textClass.givenText.add(initialText);
                textClass.verseNumbers.add(initialVerseNumber);
                initialText = "";
                flag = 0;
            }
            if (flag == 0) {
                initialText = givenText.get(k);
                initialVerseNumber = verseNumbers.get(k);

            }
        }

        return textClass;
    }

}
