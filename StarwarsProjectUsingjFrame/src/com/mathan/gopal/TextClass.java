package com.mathan.gopal;

import java.util.ArrayList;

public class TextClass {
	ArrayList<String> verseNumbers = new ArrayList<String>();
	ArrayList<String> givenText = new ArrayList<String>();
	public String name;
	
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
