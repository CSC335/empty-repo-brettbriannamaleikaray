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
import model.Account;
import model.AccountCollection;

/**
 * A BorderPane that displays a comparison of all users' top scores. Also
 * displays the currently logged in user's stats.
 */
public class LeaderboardPane extends BorderPane {

	private MemoryGameGUI memoryGame;
	private LoginPane loginPane;
	private VBox vBox;
	private TableView<Account> leaderboardTable;
	private BorderPane userStatsPane;
	private Label leaderboardHeaderText;
	private Button returnToTitleButton;

	/**
	 * Constructs the LeaderboardPane object
	 * 
	 * @param memoryGame The MemoryGameGUI object that controls the GUI
	 * @param loginPane  The LoginPane where user accounts are stored
	 */
	public LeaderboardPane(MemoryGameGUI memoryGame, LoginPane loginPane) {
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
	private TableView<Account> generateTable() {
		// Create table and columns
		TableView<Account> leaderboardTable = new TableView<Account>();

		TableColumn<Account, String> userNameColumn = new TableColumn<Account, String>("User Name");
		userNameColumn.setCellValueFactory(new PropertyValueFactory<Account, String>("username"));
		userNameColumn.setSortable(false);

		TableColumn<Account, String> lowestScoreColumn = new TableColumn<Account, String>(
				"Lowest Score");
		lowestScoreColumn.setCellValueFactory(new PropertyValueFactory<Account, String>("lowestScore"));

		TableColumn<Account, String> averageScoreColumn = new TableColumn<Account, String>(
				"Average Score");
		averageScoreColumn.setCellValueFactory(new PropertyValueFactory<Account, String>("averageScore"));

		leaderboardTable.getColumns().add(userNameColumn);
		leaderboardTable.getColumns().add(lowestScoreColumn);
		leaderboardTable.getColumns().add(averageScoreColumn);

		leaderboardTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY); // Makes column widths equals
		leaderboardTable.setSelectionModel(null);

		// Position leader board
		leaderboardTable.setMaxHeight(500);
		leaderboardTable.setPadding(new Insets(25, 100, 50, 100)); // top, right, bottom, left

		// Put user account data into table
		AccountCollection allAccounts = loginPane.getAllAccounts();
		for (int i = 0; i < allAccounts.size(); i += 1) {
			leaderboardTable.getItems().add(allAccounts.get(i));
		}

		return leaderboardTable;
	}

	private void registerListeners() {
		returnToTitleButton.setOnAction(event -> {
			memoryGame.showTitle();
		});
	}
}