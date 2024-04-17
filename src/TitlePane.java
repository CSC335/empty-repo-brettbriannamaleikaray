import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

/**
 * A BorderPane which displays the title screen, including "Start Game",
 * "Leaderboard", and "Quit" buttons. Also displays a LoginPane where a user can
 * log in to their account so that their stats are kept track of.
 */
public class TitlePane extends BorderPane {

	private MemoryGameGUI memoryGame;
	private Button startButton = new Button("Start Game");
	private Button leaderboardButton = new Button("Leaderboard");
	private Button quitButton = new Button("Quit");
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

		startButton.setFont(new Font(35));
		leaderboardButton.setFont(new Font(20));
		quitButton.setFont(new Font(20));

		buttons.setVgap(15);
		buttons.add(startButton, 0, 0);
		buttons.add(leaderboardButton, 0, 1);
		startButton.setPrefWidth(300);
		leaderboardButton.setPrefWidth(300);
		quitButton.setPrefWidth(300);
		buttons.add(quitButton, 0, 2);
		buttons.setAlignment(Pos.CENTER);

		Label label = new Label("Sonoran Memory Match");
		label.setPadding(new Insets(50, 0, 50, 0));
		label.setFont(new Font(73));
		label.setTextFill(Color.web("#EEEEEE"));
		GridPane title = new GridPane();
		title.setAlignment(Pos.CENTER);
		title.add(label, 0, 0);

		loginPane.setPadding(new Insets(0, 0, 250, 0));

		this.setTop(title);
		this.setCenter(buttons);
		this.setBottom(loginPane);

		this.setStyle("-fx-background-image: url('file:src/images/desertbackground.jpg')");
	}

	private void registerListeners() {
		startButton.setOnAction(event -> {
			memoryGame.startRound();
		});
		leaderboardButton.setOnAction(event -> {
			memoryGame.showLeaderboard();
		});
		quitButton.setOnAction(event -> {
			memoryGame.quit();
		});
	}
}
