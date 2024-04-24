package controller_view;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import model.Mode;

/**
 * A BorderPane which displays the title screen, including "Start Game",
 * "Leaderboard", and "Quit" buttons. Also displays a LoginPane where a user can
 * log in to their account so that their stats are kept track of.
 */
public class TitlePane extends BorderPane {

	private MemoryGameGUI memoryGame;
	private Button startButton = new Button("Start Normal Game");
	private Button startTimedButton = new Button("Start Timed Game");
	private Button startMatch4Button = new Button ("Start Match 4 Game");
	private Button leaderboardButton = new Button("Leaderboard");
	private Button quitButton = new Button("Quit");
	private Alert loginFirstAlt;
	private LoginPane loginPane;

	/**
	 * Constructs the TitlePane
	 * 
	 * @param memoryGame The MemoryGameGUI object that controls the GUI
	 * @param loginPane  The LoginPane where user accounts are stored
	 */
	public TitlePane(MemoryGameGUI memoryGame, LoginPane loginPane) {
		this.memoryGame = memoryGame;
		this.loginPane = loginPane;
		layoutPane();
		registerListeners();
	}

	private void layoutPane() {
		GridPane buttons = new GridPane();

		this.loginFirstAlt = new Alert(AlertType.ERROR, "Please login first!");

		startButton.setFont(new Font(25));
		startTimedButton.setFont(new Font(25));
		startMatch4Button.setFont(new Font(25));
		leaderboardButton.setFont(new Font(20));
		quitButton.setFont(new Font(20));

		// set button colors
		startButton.setStyle("-fx-background-color: papayawhip; -fx-text-fill: black;");
		startTimedButton.setStyle("-fx-background-color: papayawhip; -fx-text-fill: black;");
		startMatch4Button.setStyle("-fx-background-color: papayawhip; -fx-text-fill: black;");
		leaderboardButton.setStyle("-fx-background-color: papayawhip; -fx-text-fill: black;");
		quitButton.setStyle("-fx-background-color: papayawhip; -fx-text-fill: black;");
		
		buttons.setVgap(15);
		buttons.add(startButton, 0, 0);
		buttons.add(startTimedButton, 0, 1);
		buttons.add(startMatch4Button, 0, 2);
		buttons.add(leaderboardButton, 0, 3);
		startButton.setPrefWidth(300);
		leaderboardButton.setPrefWidth(300);
		quitButton.setPrefWidth(300);
		startTimedButton.setPrefWidth(300);
		startMatch4Button.setPrefWidth(300);
		buttons.add(quitButton, 0, 4);
		buttons.setAlignment(Pos.CENTER);

		Label label = new Label("Sonoran Memory Match");
		label.setPadding(new Insets(50, 0, 50, 0));
		label.setFont(new Font(73));
		label.setTextFill(Color.web("#EEEEEE"));
		GridPane title = new GridPane();
		title.setAlignment(Pos.CENTER);
		title.add(label, 0, 0);

		loginPane.setPadding(new Insets(15, 0, 250, 0));

		this.setTop(title);
		this.setCenter(buttons);
		this.setBottom(loginPane);

		this.setStyle(
				"-fx-background-image: url('file:src/images/desertbackground.jpg')");
	}

	private void registerListeners() {
		startButton.setOnAction(event -> {
			if (this.loginPane.isLoggedIn()) {
				memoryGame.startRound(Mode.NORMAL);
			} else {
				this.loginFirstAlt.show();
			}
		});
		startTimedButton.setOnAction(event -> {
			if (this.loginPane.isLoggedIn()) {
				memoryGame.startRound(Mode.TIMED);
			} else {
				this.loginFirstAlt.show();
			}
		});
		startMatch4Button.setOnAction(event -> {
			if (this.loginPane.isLoggedIn()) {
				memoryGame.startRound(Mode.MATCH4);
			} else {
				this.loginFirstAlt.show();
			}
		});
		leaderboardButton.setOnAction(event -> {
			if (this.loginPane.isLoggedIn()) {
				memoryGame.showLeaderboard();
			} else {
				this.loginFirstAlt.show();
			}
		});
		quitButton.setOnAction(event -> {
			memoryGame.quit();
		});
		
	}

}
