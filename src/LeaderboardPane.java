import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

/**
 * A BorderPane that displays a comparison of all users' top scores. Also
 * displays the currently logged in user's stats.
 */
public class LeaderboardPane extends BorderPane {

	private MemoryGameGUI memoryGame;
	private MockLoginPane loginPane;
	private VBox vBox;
	private TableView<MockUserAccount> leaderboardTable;
	private BorderPane userStatsPane;
	private Label leaderboardHeaderText;
	private Button returnToTitleButton;

	/**
	 * Constructs the LeaderboardPane object
	 * 
	 * @param memoryGame The MemoryGameGUI object that controls the GUI
	 * @param loginPane  The LoginPane where user accounts are stored
	 */
	public LeaderboardPane(MemoryGameGUI memoryGame, MockLoginPane loginPane) {
		this.memoryGame = memoryGame;
		this.loginPane = loginPane;
		layoutGUI();
		registerListeners();
		this.getStylesheets().add("LeaderboardStyle.css");
	}

	private void layoutGUI() {
		// Create vBox
		vBox = new VBox();
		this.setCenter(vBox);
		vBox.setSpacing(25);

		// Button
		returnToTitleButton = new Button("Return to Title Screen");

		// Labels
		leaderboardHeaderText = new Label("Leaderboard");
		Font leaderboardHeaderFont = new Font("Courier New", 80);
		leaderboardHeaderText.setFont(leaderboardHeaderFont);

		// Populate vBox
		leaderboardTable = generateTable();
		userStatsPane = new UserStatsPane(memoryGame, loginPane);
		vBox.getChildren().addAll(leaderboardHeaderText, leaderboardTable, userStatsPane, returnToTitleButton);
		vBox.setVgrow(leaderboardTable, Priority.ALWAYS); // without this we only see header of table
		vBox.setAlignment(Pos.CENTER);

		// Set background image
		this.setStyle("-fx-background-image: url('file:src/images/leaderboardbackground.jpg')");
	}

	@SuppressWarnings("deprecation")
	private TableView<MockUserAccount> generateTable() {
		// Create table and columns
		TableView<MockUserAccount> leaderboardTable = new TableView<MockUserAccount>();

		TableColumn<MockUserAccount, String> userNameColumn = new TableColumn<MockUserAccount, String>("User Name");
		userNameColumn.setCellValueFactory(new PropertyValueFactory<MockUserAccount, String>("userName"));
		userNameColumn.setSortable(false);

		TableColumn<MockUserAccount, String> lowestScoreColumn = new TableColumn<MockUserAccount, String>(
				"Lowest Score");
		lowestScoreColumn.setCellValueFactory(new PropertyValueFactory<MockUserAccount, String>("lowestScore"));

		TableColumn<MockUserAccount, String> averageScoreColumn = new TableColumn<MockUserAccount, String>(
				"Average Score");
		averageScoreColumn.setCellValueFactory(new PropertyValueFactory<MockUserAccount, String>("averageScore"));

		leaderboardTable.getColumns().add(userNameColumn);
		leaderboardTable.getColumns().add(lowestScoreColumn);
		leaderboardTable.getColumns().add(averageScoreColumn);

		leaderboardTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY); // Makes column widths equals
		leaderboardTable.setSelectionModel(null);

		// Position leader board
		leaderboardTable.setMaxHeight(500);
		leaderboardTable.setPadding(new Insets(25, 100, 50, 100)); // top, right, bottom, left

		// Put user account data into table
		for (int i = 0; i < loginPane.getMockAccountCollectionSize(); i += 1) {
			leaderboardTable.getItems().add(loginPane.getAccount(i));
		}

		return leaderboardTable;
	}

	private void registerListeners() {
		returnToTitleButton.setOnAction(event -> {
			memoryGame.showTitle();
		});
	}
}