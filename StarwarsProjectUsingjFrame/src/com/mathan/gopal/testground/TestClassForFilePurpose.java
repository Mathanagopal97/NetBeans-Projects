package com.mathan.gopal.testground;

import java.io.File;

/*import java.util.ArrayList;
import java.util.Collection;
*/
public class TestClassForFilePurpose {
	static String stripExtension(String str) {

		if (str == null)
			return null;

		int pos = str.lastIndexOf(".");

		if (pos == -1)
			return str;

		return str.substring(0, pos);
	}

	public static void main(String[] args) {
		
		//Get all the extensions 
		/*
		 * Collection<File> all = new ArrayList<File>();
		 * addTree(new File(".\\Subtitles"), all); System.out.println(all);
		 */

		File actual = new File(".\\Subtitles");
		for (File f : actual.listFiles()) {
			String fileName = f.getName();
			System.out.println(stripExtension(fileName));
			//System.out.println(fileName.replaceFirst("[.][^.]+$", ""));
		}
	}

	// Snippet for the comment part in the main method
	/*
	 * static void addTree(File file, Collection<File> all) { File[] children =
	 * file.listFiles(); if (children != null) { for (File child : children) {
	 * all.add(child); addTree(child, all); } } }
	 */

}
