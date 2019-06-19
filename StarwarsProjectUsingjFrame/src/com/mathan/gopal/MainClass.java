package com.mathan.gopal;

import java.io.File;
import java.util.ArrayList;

public class MainClass {
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		ArrayList<TextClass> textClassArrayList = new ArrayList<TextClass>();
		ArrayList<String> name = new ArrayList<String>();

		File actual = new File(".\\Subtitles");
		for (File f : actual.listFiles()) {
			String fileName = f.getName();
			fileName = fileName.replaceFirst("[.][^.]+$", "");
			name.add(fileName);
		}

		for (int i = 0; i < 10; i++) {
			int escapeChar;
			TextClass textClassObject = new TextClass();
			if (i == 3)
				escapeChar = 10;
			else
				escapeChar = 13;
			textClassArrayList.add(DataRetreiver.retreiveData(textClassObject, name.get(i), escapeChar));
		}

		/*
		 * for (int i = 0; i < 10; i++) { System.out.println("Name: " +
		 * textClassArrayList.get(i).getName() + " Verse Numbers: " +
		 * textClassArrayList.get(i).getVerseNumbers().size() + " Given Text: " +
		 * textClassArrayList.get(i).getGivenText().size());
		 * 
		 * }
		 */

		/*
		 * int k = 3; System.out.println(textClassArrayList.get(k).getVerseNumbers());
		 * for (int n = 0; n < textClassArrayList.get(k).getGivenText().size(); n++)
		 * System.out.println(textClassArrayList.get(k).getGivenText().get(n));
		 */

		String searchString = "Gen";

		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < textClassArrayList.get(i).getGivenText().size(); j++) {
				String testCase = textClassArrayList.get(i).getGivenText().get(j);
				if (testCase.contains(searchString)) {
					System.out.println(testCase + " (" + (textClassArrayList.get(i).name.replace("_"," ")) + " "
							+ textClassArrayList.get(i).getVerseNumbers().get(j) + ")");
				}
			}
		}

	}
}
