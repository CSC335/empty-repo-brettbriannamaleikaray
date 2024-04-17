package controller_view;
import java.util.ArrayList;

import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.GridPane;
import model.Account;
import model.AccountCollection;

/**
 * The login pane of our GUI; a place for users to login or create an account
 */
public class LoginPane extends GridPane {
	
	// Nodes
	private Label usernameLbl = new Label("Username: ");
	private TextField usernameFld = new TextField();
	private Label passwordLbl = new Label("Password: ");
	private PasswordField passwordFld = new PasswordField();
	private Button loginBtn = new Button("Login");
	private Button createAccountBtn = new Button("Create Account");
	
	// Other fields
	private MemoryGameGUI memoryGameGUI;
	private Account curAccount;
	private AccountCollection allAccounts;
	
	/**
	 * 
	 * @param memoryGameGUI
	 */
	public LoginPane(MemoryGameGUI memoryGameGUI) {	
		this.memoryGameGUI = memoryGameGUI;
		this.curAccount = null;
		this.allAccounts = new AccountCollection();
		
		addDefaultAccounts();
		layoutPane();
		setHandlers();
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
	
	/**
	 * Add default accounts to account collection
	 */
	private void addDefaultAccounts() {
		this.allAccounts.add(new Account("brett", "brimmer"));
		this.allAccounts.add(new Account("brianna", "yuki"));
		this.allAccounts.add(new Account("maleika", "fleming"));
		this.allAccounts.add(new Account("ray", "xiang"));
	}
	
	/**
	 * Set event handlers here
	 */
	private void setHandlers() {
		loginBtn.setOnAction(e -> {
			String username = usernameFld.getText();
			String password = passwordFld.getText();
			usernameFld.setText("");
			passwordFld.setText("");
			this.curAccount = this.allAccounts.findAccount(username, password);
			if (this.curAccount != null) {
				LeaderboardPane newLeaderboardPane;
				newLeaderboardPane = new LeaderboardPane(memoryGameGUI, this);
				this.memoryGameGUI.setLeaderboardPane(newLeaderboardPane);
			} else {
				Alert alert = new Alert(AlertType.CONFIRMATION);
				alert.setHeaderText("Invalid credentials");
				alert.showAndWait();
			}
		});
		
		createAccountBtn.setOnAction(e -> {
			String username = usernameFld.getText();
			String password = passwordFld.getText();
			usernameFld.setText("");
			passwordFld.setText("");
			if (allAccounts.usernameTaken(username)) {
				Alert alert = new Alert(AlertType.CONFIRMATION);
				alert.setHeaderText("Username Taken");
				alert.showAndWait();
			} else {
				this.allAccounts.add(new Account(username, password));
			}
		});
	}
	
	/**
	 * @return Returns true if the user has logged in
	 */
	public boolean isLoggedIn() {
		return this.curAccount != null;
	}
	
	/**
	 * @return The current account
	 */
	public Account getCurrentAccount() {
		return this.curAccount;
	}
	
	/**
	 * @return All existing accounts
	 */
	public AccountCollection getAllAccounts() {
		return this.allAccounts;
	}
	
	public void setAllAccounts(ArrayList<Account> accounts) {
		this.allAccounts.setAccounts(accounts);
	}
}
