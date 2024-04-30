package model;

/**
 * An object from this class represents a sound or music file and stores the
 * name of the sound/music and its file path
 */
public class Sound {
	private String name;
	private String filePath;

	/**
	 * Instantiates a Sound object with parameters that will allow us to recognize
	 * the name of the sound file and its path
	 * 
	 * @param name     The name of the mp3/wav file including the extension
	 *                 (example: "thisSound.wav")
	 * @param fileName The file path of the sound file in the project
	 */
	public Sound(String name) {
		this.name = name;
		this.filePath = "src/sounds/" + this.name;
	}

	public String getName() {
		return name;
	}

	public String getFilePath() {
		return filePath;
	}
}