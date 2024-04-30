package model;

import java.io.File;
import java.net.URI;
import java.util.ArrayList;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

/**
 * Holds a collection of Sound objects in a SoundCollection ArrayList. Can play
 * songs from those Sound objects' sound file paths
 */
public class SoundPlayer {
	private ArrayList<Sound> soundCollection;
	private MediaPlayer mediaPlayer;
	private boolean isMusicPlayer;

	/**
	 * Constructs the SoundPlayer object
	 */
	public SoundPlayer(boolean isMusicPlayer) {
		soundCollection = new ArrayList<Sound>();
		this.isMusicPlayer = isMusicPlayer; // If true, we loop the sound

		// Hard code sounds
		addSound("snd_button_click.wav");
		addSound("snd_button_hover.wav");
		addSound("snd_titlemusic.wav");
		addSound("snd_cardflip1.wav");
		addSound("snd_cardflip2.wav");
		addSound("snd_cardflip3.wav");
		addSound("snd_win.wav");
		addSound("snd_lose.wav");
		addSound("snd_carddestroy.wav");
		addSound("snd_dealcards.wav");
	}

	/**
	 * Adds a Sound object to the soundCollection ArrayList
	 * 
	 * @param sound the Sound object to be added to soundCollection
	 */
	public void addSound(String soundName) {
		soundCollection.add(new Sound(soundName));
	}

	/**
	 * Plays a sound from the sound collection, using the soundName to find the
	 * Sound object that knows the file path
	 * 
	 * @param soundName The "name" parameter of a Sound object
	 */
	public void playSound(String soundName) {
		for (int i = 0; i < soundCollection.size(); i += 1) {
			if (soundCollection.get(i).getName().equals(soundName)) {
				Sound soundToPlay = soundCollection.get(i);

				// Convert Sound object to Media object
				File file = new File(soundToPlay.getFilePath());
				URI uri = file.toURI();
				Media media = new Media(uri.toString());

				// Play sound
				this.mediaPlayer = new MediaPlayer(media);
				this.mediaPlayer.play();
			}
		}

		// Loop music
		if (this.isMusicPlayer == true) {
			mediaPlayer.setOnEndOfMedia(new Runnable() {
				@Override
				public void run() {
					mediaPlayer.seek(Duration.ZERO);
					mediaPlayer.play();
				}
			});
		}
	}

	/**
	 * Stops playing the current sound
	 */
	public void stopPlaying() {
		this.mediaPlayer.stop();
	}

}
