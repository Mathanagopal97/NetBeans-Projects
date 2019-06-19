/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mathan.starwarsproject;

import java.io.FileReader;

/**
 *
 * @author HP
 */
public class DataRetriever {

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

                        textClass.givenText.add(text);
                        text = "";

                    }
                    step = 1;
                } else if (step == 1) {
                    // System.out.println(dummy);
                    String verseNumber = ""
                            + ((Integer.parseInt(dummy.split(" to ")[0].split(",")[0].split(":")[0]) * 60)
                            + Integer.parseInt(dummy.split(" to ")[0].split(",")[0].split(":")[1]))
                            + ":" + Integer.parseInt(dummy.split(" to ")[0].split(",")[0].split(":")[2]);
                    textClass.verseNumbers.add(verseNumber);
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
        textClass.givenText.add(text);
        fr.close();

        return textClass;
    }

}
