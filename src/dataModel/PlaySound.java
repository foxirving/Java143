package dataModel;
import java.io.File;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;


public class PlaySound extends Thread{
	String file;
	public PlaySound(String s){
		file = s;
	}

	public void run(){
		String fileName =  "src/SoundFiles/"+file;
		try {
			Clip clip = AudioSystem.getClip();
			clip.open(AudioSystem.getAudioInputStream(new File(fileName)));
			clip.start();
			Thread.sleep(1000);
			clip.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
