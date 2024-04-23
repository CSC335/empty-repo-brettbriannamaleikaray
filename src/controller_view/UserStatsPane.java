package controller_view;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

/**
 * A BorderPane that displays the currently logged-in user's account name and
 * stats
 */
public class UserStatsPane extends BorderPane {

	private MemoryGameGUI memoryGame;
	private LoginPane loginPane;
	private ListView<String> statsList;
	private Label userStatsHeaderText;
	private VBox vBox;

	/**
	 * Constructs the UserStatsPane
	 * 
	 * @param memoryGame The MemoryGameGUI object that controls the GUI
	 * @param loginPane  The LoginPane where user accounts are stored
	 */
	public UserStatsPane(MemoryGameGUI memoryGame, LoginPane loginPane) {
		this.memoryGame = memoryGame;
		this.loginPane = loginPane;
		statsList = generateListView();
		this.getStylesheets().add("file:src/controller_view/UserStatsStyle.css");

		layoutGUI();
	}

	private void layoutGUI() {
		// Header label
		String loggedInAccountName = (String) loginPane.getCurrentAccount().getUsername();
		userStatsHeaderText = new Label(loggedInAccountName + "'s Stats");
		Font userStatsHeaderFont = Font.font("Courier New", FontWeight.NORMAL, 28);
		userStatsHeaderText.setFont(userStatsHeaderFont);

		// Set up VBox
		vBox = new VBox();
		statsList = generateListView();
		vBox.getChildren().addAll(userStatsHeaderText, statsList);
		vBox.setAlignment(Pos.CENTER);
		this.setCenter(vBox);
	}

	private ListView<String> generateListView() {
		ListView<String> newStatsList = new ListView<>();

		// Add items
		newStatsList.getItems().add("Rounds Played: " + loginPane.getCurrentAccount().getRoundsPlayed());
		newStatsList.getItems().add("Total Wins: " + loginPane.getCurrentAccount().getTotalWins());
		newStatsList.getItems().add("Average Score: " + loginPane.getCurrentAccount().getAverageScore());
		newStatsList.getItems().add("Lowest Score: " + loginPane.getCurrentAccount().getHighestScore());

		// Set size
		newStatsList.setMaxWidth(300);
		newStatsList.setMaxHeight(200);

		return newStatsList;
	}
}