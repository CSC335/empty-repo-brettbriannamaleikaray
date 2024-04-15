import java.util.ArrayList;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

public class MockLoginPane extends BorderPane {
	private MockUserAccount loggedInAccount;
	private MemoryGameGUI memorygame;
	private ArrayList<MockUserAccount> mockAccountCollection;
	
	private Label mockLoginPaneText;
	private Label userNameText;
	private Label passwordText;
	private Label createAccountText;
	
	public MockLoginPane(MemoryGameGUI memoryGame) {
		this.memorygame = memoryGame;
		
		// Generate a list of mock accounts
		mockAccountCollection = new ArrayList<MockUserAccount>();
		
		mockAccountCollection.add(new MockUserAccount("Rick"));
		mockAccountCollection.add(new MockUserAccount("Ashley"));
		mockAccountCollection.add(new MockUserAccount("James"));
		mockAccountCollection.add(new MockUserAccount("Jennifer"));
		mockAccountCollection.add(new MockUserAccount("Candace"));
		mockAccountCollection.add(new MockUserAccount("Harold"));
		
		// Set logged in account
		loggedInAccount = mockAccountCollection.get(0);
		
		// Lay out labels
		layoutGUI();
	}
	
	public MockUserAccount getAccount(int index) {
		return mockAccountCollection.get(index);
	}
	
	public int getMockAccountCollectionSize() {
		return mockAccountCollection.size();
	}
	
	public String getLoggedInAccountName() {
		return loggedInAccount.getUserName();
	}
	
	public MockUserAccount getLoggedInAccount() {
		return loggedInAccount;
	}
	
	private void layoutGUI() {
		GridPane gridPane = new GridPane();
		this.setCenter(gridPane);
		
		// Set label text
		mockLoginPaneText = new Label("This is where the login pane could go.");
		userNameText = new Label("[User Name Button] [User Name Text Field]");
		passwordText = new Label("[Password Button] [Password Text Field]");
		createAccountText = new Label("[Create Account Button]");
		mockLoginPaneText.setTextFill(Color.WHITE);
		userNameText.setTextFill(Color.WHITE);
		passwordText.setTextFill(Color.WHITE);
		createAccountText.setTextFill(Color.WHITE);
		
		// Add labels to gridpane
		gridPane.add(mockLoginPaneText, 1, 0);
		gridPane.add(userNameText, 1, 1);
		gridPane.add(passwordText, 1, 2);
		gridPane.add(createAccountText, 1, 3);
		gridPane.setAlignment(Pos.CENTER);
		
		// Set size
		this.setPrefWidth(300);
		this.setPrefHeight(200);
	}
}
