/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mathan.audioconversion;

/**
 *
 * @author HP
 * Source - https://www.youtube.com/watch?v=A8Z9LrdpP0w
 * JARs From - http://www.sauronsoftware.it/projects/jave/download.php
 * 
 */
/*
 * For some Wierd Things go to this webiste
 * https://www.javatips.net/api/java-learning-notes-cn-master/Image%20&%20Video/video/CaptureScreenToFile.java
*/



import java.io.File;

import it.sauronsoftware.jave.EncoderException;
import it.sauronsoftware.jave.InputFormatException;
public class MainClass {
    
    public static void main(String[] args) {
		String path="D:/Mathan/VideoForTest.mp4";
		try {
			File video= new File(path);
			VideoToAudio.convertToAudio(video);
			//VideoToAudio.convertToMP3(video);
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

    
}
