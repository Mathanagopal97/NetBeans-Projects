package com.mathan.gopal.testground;

public class TestClassForDate {
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String dummy = "01:57:46,315 to 01:57:47,577";
		String verseNumber = ""
				+ ((Integer.parseInt(dummy.split(" to ")[0].split(",")[0].split(":")[0]) * 60)
						+ Integer.parseInt(dummy.split(" to ")[0].split(",")[0].split(":")[1]))
				+ ":" + Integer.parseInt(dummy.split(" to ")[0].split(",")[0].split(":")[2]);
		System.out.println(verseNumber);

	}

}
