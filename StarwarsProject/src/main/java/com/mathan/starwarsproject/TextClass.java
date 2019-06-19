/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mathan.starwarsproject;

import java.util.ArrayList;

/**
 *
 * @author HP
 */
public class TextClass {

    ArrayList<String> verseNumbers = new ArrayList<String>();
    ArrayList<String> givenText = new ArrayList<String>();
    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<String> getVerseNumbers() {
        return verseNumbers;
    }

    public void setVerseNumbers(ArrayList<String> verseNumbers) {
        this.verseNumbers = verseNumbers;
    }

    public ArrayList<String> getGivenText() {
        return givenText;
    }

    public void setGivenText(ArrayList<String> givenText) {
        this.givenText = givenText;
    }

}
