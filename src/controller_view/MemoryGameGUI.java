package controller_view;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Optional;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import model.Account;

/**
 * Starts the Sonoran Memory Game app. Initially displays a TitlePane that
 * displays the title screen. When a user goes to another "screen" (such as the
 * game or leaderboard screens) this class swaps out the currently displayed
 * pane for a pane that displays the desired screen.
 */
public class MemoryGameGUI extends Application {

	private BorderPane pane = new BorderPane();
	private TitlePane titlePane;
	private LoginPane loginPane;
	private MockLoginPane mockLoginPane;
	private LeaderboardPane leaderboardPane;
	private Stage stage;

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
		loginPane = new LoginPane(this);
		mockLoginPane = new MockLoginPane(this);

		titlePane = new TitlePane(this, loginPane);
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
	 */
	public void startRound() {
		pane.setCenter(new RoundPane(this));
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
				@SuppressWarnings("unchecked")
				ArrayList<Account> old = (ArrayList<Account>) in.readObject();
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
