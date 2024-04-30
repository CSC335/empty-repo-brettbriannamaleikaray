package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import model.Sound;

class TestSound {

	@Test
	void SoundTest() {
		Sound testSound = new Sound("sound name");

		// Test get name and filename
		assertEquals("sound name", testSound.getName());
		assertEquals("src/sounds/" + "sound name", testSound.getFilePath());
	}
}