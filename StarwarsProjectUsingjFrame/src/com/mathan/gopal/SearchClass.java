/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mathan.gopal;

import java.util.ArrayList;

/**
 *
 * @author HP
 */
public class SearchClass {

    public static ArrayList<ArrayList<String> > searchFunction(ArrayList<TextClass> textClassArrayList, String searchString) {
        ArrayList<String> result = new ArrayList<String>();
        ArrayList<String> phrases = new ArrayList<String>();
        
        ArrayList<ArrayList<String> > finalResult =  
                  new ArrayList<ArrayList<String> >();
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < textClassArrayList.get(i).getGivenText().size(); j++) {
                String testCase = textClassArrayList.get(i).getGivenText().get(j);
                if (testCase.toLowerCase().contains(searchString.toLowerCase())) {
                    int index = testCase.toLowerCase().indexOf(searchString.toLowerCase());
                    if (phrases.size() > 0 && phrases.contains(testCase.substring(index, index + searchString.length()))) {
                    } else {
                        phrases.add(testCase.substring(index, index + searchString.length()));
                    }

                    result.add(testCase + " (" + (textClassArrayList.get(i).name.replace("_", " ")) + " "
                            + textClassArrayList.get(i).getVerseNumbers().get(j) + ")");
                }
            }
        }
        finalResult.add(result);
        finalResult.add(phrases);
        return finalResult;
    }
}
