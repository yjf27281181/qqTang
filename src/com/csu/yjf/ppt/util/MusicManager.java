package com.csu.yjf.ppt.util;

import java.applet.Applet;
import java.applet.AudioClip;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

public class MusicManager {
	
	public MusicManager() {
		
	}
	
	public AudioClip getBackgroudMusic() {
		File musicFile=new File("src/Music/bgm.wav");
		URI uri=musicFile.toURI();
		URL url = null;
		try {			//file:///C:/Documents%20and%20Settings
			url = uri.toURL();
			System.out.println(url);
		} catch (MalformedURLException e1) {

		e1.printStackTrace();
		}
		AudioClip clip=Applet.newAudioClip(url);
		return clip;
	}
	
	public AudioClip getSounds_putBubble() {
		File musicFile=new File("src/Music/putBubble.wav");
		URI uri=musicFile.toURI();
		URL url = null;
		try {			//file:///C:/Documents%20and%20Settings
			url = uri.toURL();
			System.out.println(url);
		} catch (MalformedURLException e1) {

		e1.printStackTrace();
		}
		AudioClip clip=Applet.newAudioClip(url);
		return clip;
	}
	
	
	public AudioClip getSounds_bubbleBomb() {
		File musicFile=new File("src/Music/bubbleBomb.wav");
		URI uri=musicFile.toURI();
		URL url = null;
		try {			//file:///C:/Documents%20and%20Settings
			url = uri.toURL();
			System.out.println(url);
		} catch (MalformedURLException e1) {

		e1.printStackTrace();
		}
		AudioClip clip=Applet.newAudioClip(url);
		return clip;
	}
	
	public AudioClip getSounds_getGoods() {
		File musicFile=new File("src/Music/getGoods.wav");
		URI uri=musicFile.toURI();
		URL url = null;
		try {			//file:///C:/Documents%20and%20Settings
			url = uri.toURL();
			System.out.println(url);
		} catch (MalformedURLException e1) {

		e1.printStackTrace();
		}
		AudioClip clip=Applet.newAudioClip(url);
		return clip;
	}

}
