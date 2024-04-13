import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class LeaderboardPane extends Application {
	private BorderPane pane = new BorderPane();

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		layoutGUI();

		// Set scene
		Scene scene = new Scene(pane, 1000, 1000);
		scene.getStylesheets().add("LeaderboardStyle.css");
		stage.setScene(scene);
		stage.show();
	}
	
	private void layoutGUI() {
		// Generate leaderboard table and add to pane
		pane.setCenter(generateTable());
		
		// Set background image
        pane.setStyle("-fx-background-image: url('file:src/images/leaderboardbackground.jpg')");
	}

	private TableView generateTable() {
		// Create table and columns
		TableView leaderboardTable = new TableView<MockUserAccount>();

		TableColumn userNameColumn = new TableColumn<MockUserAccount, String>("User Name");
		userNameColumn.setCellValueFactory(new PropertyValueFactory<MockUserAccount, String>("userName"));
		userNameColumn.setSortable(false);

		TableColumn lowestScoreColumn = new TableColumn<MockUserAccount, String>("Lowest Score");
		lowestScoreColumn.setCellValueFactory(new PropertyValueFactory<MockUserAccount, String>("lowestScore"));

		TableColumn winPercentageColumn = new TableColumn<MockUserAccount, String>("Win Percentage");
		winPercentageColumn.setCellValueFactory(new PropertyValueFactory<MockUserAccount, String>("winPercentage"));

		leaderboardTable.getColumns().add(userNameColumn);
		leaderboardTable.getColumns().add(lowestScoreColumn);
		leaderboardTable.getColumns().add(winPercentageColumn);

		leaderboardTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
		leaderboardTable.setSelectionModel(null);

		// Position leader board
		leaderboardTable.setPadding(new Insets(100, 100, 400, 100));

		// Add columns
		leaderboardTable.getItems().add(new MockUserAccount("Ashley"));
		leaderboardTable.getItems().add(new MockUserAccount("James"));
		leaderboardTable.getItems().add(new MockUserAccount("Jennifer"));
		leaderboardTable.getItems().add(new MockUserAccount("Candice"));
		leaderboardTable.getItems().add(new MockUserAccount("Harold"));
		
		return leaderboardTable;
	}
}
