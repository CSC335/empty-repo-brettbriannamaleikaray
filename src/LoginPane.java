import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class LoginPane extends GridPane {
	
	// Nodes
	private Label usernameLbl = new Label("Username: ");
	private TextField usernameFld = new TextField();
	private Label passwordLbl = new Label("Password: ");
	private TextField passwordFld = new TextField();
	private Button loginBtn = new Button("Login");
	private Button createAccountBtn = new Button("Create Account");
	
	// Other fields
	private MemoryGameGUI memoryGameGUI;
	
	/**
	 * 
	 * @param memoryGameGUI
	 */
	public LoginPane(MemoryGameGUI memoryGameGUI) {		
		layoutPane();
		
		this.memoryGameGUI = memoryGameGUI;
	}
	
	/**
	 * Insert and style GUI elements
	 */
	private void layoutPane() {
		this.add(usernameLbl, 0, 0);
		this.add(usernameFld, 1, 0);
		this.add(passwordLbl, 0, 1);
		this.add(passwordFld, 1, 1);
		this.add(loginBtn, 0, 2);
		this.add(createAccountBtn, 1, 2);
		
		this.setAlignment(Pos.CENTER);
		this.setVgap(10);
		this.setHgap(10);
	}
	
}
