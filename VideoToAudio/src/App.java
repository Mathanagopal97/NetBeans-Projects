import java.io.File;

import it.sauronsoftware.jave.EncoderException;
import it.sauronsoftware.jave.InputFormatException;

public class App {

	public static void main(String[] args) {
		String path="C:/Users/KL/Desktop/a.mp4";
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
