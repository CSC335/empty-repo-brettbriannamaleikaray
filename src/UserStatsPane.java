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
	private MockLoginPane loginPane;
	private ListView<String> statsList;
	private Label userStatsHeaderText;
	private VBox vBox;

	/**
	 * Constructs the UserStatsPane
	 * 
	 * @param memoryGame The MemoryGameGUI object that controls the GUI
	 * @param loginPane  The LoginPane where user accounts are stored
	 */
	public UserStatsPane(MemoryGameGUI memoryGame, MockLoginPane loginPane) {
		this.memoryGame = memoryGame;
		this.loginPane = loginPane;
		statsList = generateListView();
		this.getStylesheets().add("UserStatsStyle.css");

		layoutGUI();
	}

	private void layoutGUI() {
		// Header label
		String loggedInAccountName = (String) loginPane.getLoggedInAccountName();
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
		newStatsList.getItems().add("Rounds Played: " + loginPane.getLoggedInAccount().getRoundsPlayed());
		newStatsList.getItems().add("Total Wins: " + loginPane.getLoggedInAccount().getTotalWins());
		newStatsList.getItems().add("Average Score: " + loginPane.getLoggedInAccount().getAverageScore());
		newStatsList.getItems().add("Lowest Score: " + loginPane.getLoggedInAccount().getLowestScore());

		// Set size
		newStatsList.setMaxWidth(300);
		newStatsList.setMaxHeight(200);

		return newStatsList;
	}
}