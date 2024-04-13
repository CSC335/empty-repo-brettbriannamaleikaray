import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import model.Card;
import model.Table;

public class TestTable extends Application {
	
	public static void main(String args[]) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
	    GridPane pane = new GridPane();
	    // change first parameter to change category
	    Table table = new Table("cacti", 4);
	    Card[] cards = table.getRandomizedCards();
	    
	    // adds randomized card images to grid pane
	    for (int i = 0; i < 8; i ++) {
	    	ImageView imageView = new ImageView(new Image(cards[i].getFileName()));
	    	imageView.setFitHeight(200);
		    imageView.setFitWidth(125);
		    if (i < 4) {
		    	pane.add(imageView, i % 4, 0);
		    } else {
		    	pane.add(imageView, i % 4, 1);
		    }
	    }
	    
	    Scene scene = new Scene(pane, 500, 400);
	    stage.setScene(scene);
	    stage.show();
	
	}

}
