import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MemoryGameGUI extends Application {
	
	public static void main(String args[]) {
		launch(args);
	}
	
	private BorderPane pane = new BorderPane();

	@Override
	public void start(Stage stage) throws Exception {
		pane.setCenter(new TitlePane(this));
		Scene scene = new Scene(pane, 1000, 1000);
		stage.setScene(scene);
		stage.show();
	}
	
	public void quit() {
		System.exit(0);
	}
	
	public void showLeaderboard() {
		pane.setCenter(new LeaderboardPane(this));
	}
	
	public void startRound() {
		pane.setCenter(new RoundPane(this));
	}
}
