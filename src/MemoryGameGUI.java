import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

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
		leaderboardPane = new LeaderboardPane(this, mockLoginPane);
		pane.setCenter(titlePane);

		Scene scene = new Scene(pane, 1000, 1000);
		stage.setScene(scene);
		stage.show();
		stage.setResizable(false);
	}
	
	/**
	 * @return The login pane of our GUI
	 */
	public LoginPane getLoginPane() {
		return this.loginPane;
	}

	/**
	 * Quits the program
	 */
	public void quit() {
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
}
