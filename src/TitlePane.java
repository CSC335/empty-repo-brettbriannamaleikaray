
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;

public class TitlePane extends BorderPane {
	
	private MemoryGameGUI memoryGame;
	private Button startButton = new Button("Start Game");
	private Button leaderboardButton = new Button("Leaderboard");
	private Button quitButton = new Button("Quit");
	
	public TitlePane(MemoryGameGUI memoryGame) {
		this.memoryGame = memoryGame;
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
		
		Label label = new Label("Memory Game");
		label.setPadding(new Insets(50, 0, 50, 0));
		label.setFont(new Font(125));
		GridPane title = new GridPane();
		title.setAlignment(Pos.CENTER);
		title.add(label, 0, 0);
		
		this.setTop(title);
		this.setCenter(buttons);
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
