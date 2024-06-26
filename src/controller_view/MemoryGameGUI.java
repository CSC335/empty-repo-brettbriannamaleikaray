package controller_view;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Optional;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import model.AccountCollection;
import model.Mode;
import model.SoundPlayer;

/**
 * Starts the Sonoran Memory Game application. Initially displays the TitlePane, 
 * which is the home page. When a user clicks to another page (such as the 
 * LeaderBoardPane) this class swaps out the currently displayed pane for the 
 * desired one.
 */
public class MemoryGameGUI extends Application {

	private BorderPane pane = new BorderPane();
	private TitlePane titlePane;
	private LoginPane loginPane;
	private LeaderboardPane leaderboardPane;
	private Stage stage;
	private SoundPlayer soundPlayer;
	private SoundPlayer musicPlayer;

	/**
	 * The main method
	 * 
	 * @param args Execution parameters
	 */
	public static void main(String args[]) {
		launch(args);
	}

	/**
	 * Starts the Application
	 */
	@Override
	public void start(Stage stage) throws Exception {
		soundPlayer = new SoundPlayer(false);
		musicPlayer = new SoundPlayer(true);
		loginPane = new LoginPane(this, soundPlayer);

		// Play title music
		musicPlayer.playSound("snd_titlemusic.wav");

		titlePane = new TitlePane(this, loginPane, soundPlayer, musicPlayer);
		pane.setCenter(titlePane);

		Scene scene = new Scene(pane, 1000, 1000);
		this.stage = stage;
		this.stage.setScene(scene);
		this.stage.show();
		this.stage.setResizable(false);
		this.stage.setOnCloseRequest(e -> {
			closeProgramSteps();
		});

		startupPreamble();
	}

	/**
	 * @return The login pane of our GUI
	 */
	public LoginPane getLoginPane() {
		return this.loginPane;
	}

	public void setLeaderboardPane(LeaderboardPane leaderboardPane) {
		leaderboardPane = new LeaderboardPane(this, loginPane, soundPlayer);
		this.leaderboardPane = leaderboardPane;
	}

	/**
	 * Quits the program
	 */
	public void quit() {
		closeProgramSteps();
		System.exit(0);
	}

	/**
	 * Goes to the Leaderboard screen by displaying LeaderboardPane
	 */
	public void showLeaderboard() {
		leaderboardPane = new LeaderboardPane(this, loginPane, soundPlayer);
		pane.setCenter(leaderboardPane);
	}

	/**
	 * Goes to the Title screen by displaying TitlePane
	 */
	public void showTitle() {
		pane.setCenter(titlePane);
	}

	/**
	 * Goes to the gameplay screen by displaying RoundPane
	 * 
	 * @param mode the game mode of the round to start
	 */
	public void startRound(Mode mode) {
		if (mode == Mode.NORMAL || mode == Mode.EASY || mode == Mode.TIMED || mode == Mode.LIMITED) {
			pane.setCenter(new RoundPane(this, mode, soundPlayer));
		} else if (mode == Mode.MATCH4) {
			pane.setCenter(new Match4RoundPane(this, mode, soundPlayer));
		}
	}

	private void startupPreamble() {
		Alert alert = new Alert(AlertType.CONFIRMATION, "Read saved data?");
		alert.setHeaderText("Read saved data?");
		alert.setTitle("Start up option");
		// Not sure if we need the line below
		// alert.setContentText("Please cancel while system testing");

		Optional<ButtonType> alertOption = alert.showAndWait();
		if (alertOption.get() == ButtonType.OK) {
			try {
				FileInputStream rawBytes = new FileInputStream("objects.ser");
				ObjectInputStream in = new ObjectInputStream(rawBytes);
				AccountCollection old = (AccountCollection) in.readObject();
				loginPane.setAllAccounts(old);
				in.close();
			} catch (IOException e) {
				System.out.println("Read saved accounts failed!");
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				System.out.println("Wrong cast from file!");
				e.printStackTrace();
			}
		}
	}

	private void closeProgramSteps() {
		Alert exitAlert = new Alert(AlertType.CONFIRMATION, "Save data?");

		exitAlert.setHeaderText("Save data?");
		exitAlert.setTitle("Shut down option");
		exitAlert.setContentText("Please cancel while system testing");

		Optional<ButtonType> exitAlertOption = exitAlert.showAndWait();

		if (exitAlertOption.isPresent()) {
			if (exitAlertOption.get() == ButtonType.OK) {
				String fileName = "objects.ser";
				try {
					FileOutputStream bytesToDisk = new FileOutputStream(fileName);
					ObjectOutputStream out = new ObjectOutputStream(bytesToDisk);
					out.writeObject(loginPane.getAllAccounts());
					out.close();
				} catch (IOException exception) {
					System.out.println("Save existing accounts failed!");
					exception.printStackTrace();
				}
			}
		}
	}
}
