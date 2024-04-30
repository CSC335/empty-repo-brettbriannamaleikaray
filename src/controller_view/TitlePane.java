package controller_view;

import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import model.Mode;
import model.SoundPlayer;

/**
 * A BorderPane which displays the title screen, including "Start Game",
 * "Leaderboard", and "Quit" buttons. Also displays a LoginPane where a user can
 * log in to their account so that their stats are kept track of.
 */
public class TitlePane extends BorderPane {

	private MemoryGameGUI memoryGame;
	private Button startButton = new Button("Start Normal Game");
	private Button startEasyButton = new Button("Start Easy Game");
	private Button startTimedButton = new Button("Start Timed Game");
	private Button startMatch4Button = new Button("Start Match 4 Game");
	private Button startLimitedButton = new Button("Start Limited Guess Game");
	private Button leaderboardButton = new Button("Leaderboard");
	private Button quitButton = new Button("Quit");
	private Alert loginFirstAlt;
	private LoginPane loginPane;
	private SoundPlayer soundPlayer;
	private SoundPlayer musicPlayer;

	/**
	 * Constructs the TitlePane
	 * 
	 * @param memoryGame The MemoryGameGUI object that controls the GUI
	 * @param loginPane  The LoginPane where user accounts are stored
	 */
	public TitlePane(MemoryGameGUI memoryGame, LoginPane loginPane,
			SoundPlayer soundPlayer, SoundPlayer musicPlayer) {
		this.memoryGame = memoryGame;
		this.loginPane = loginPane;
		this.soundPlayer = soundPlayer;
		this.musicPlayer = musicPlayer;
		layoutPane();
		registerListeners();
	}

	private void layoutPane() {
		GridPane buttons = new GridPane();
		buttons.setVgap(15);
		buttons.setAlignment(Pos.CENTER);

		this.loginFirstAlt = new Alert(AlertType.ERROR, "Please login first!");

		startButton.setFont(new Font(25));
		startEasyButton.setFont(new Font(25));
		startTimedButton.setFont(new Font(25));
		startMatch4Button.setFont(new Font(25));
		startLimitedButton.setFont(new Font(25));
		leaderboardButton.setFont(new Font(20));
		quitButton.setFont(new Font(20));

		// Style buttons
		String btnStyle = "-fx-background-color: papayawhip; "
						+ "-fx-text-fill: black; ";
		startButton.setStyle(btnStyle);
		startEasyButton.setStyle(btnStyle);
		startTimedButton.setStyle(btnStyle);
		startMatch4Button.setStyle(btnStyle);
		startLimitedButton.setStyle(btnStyle);
		leaderboardButton.setStyle(btnStyle);
		quitButton.setStyle(btnStyle);

		// Add buttons to button GridPane
		buttons.add(startButton, 0, 0);
		buttons.add(startEasyButton, 0, 1);
		buttons.add(startTimedButton, 0, 2);
		buttons.add(startMatch4Button, 0, 3);
		buttons.add(startLimitedButton, 0, 4);
		buttons.add(leaderboardButton, 0, 5);
		buttons.add(quitButton, 0, 6);
		
		// Set button width
		int btnPrefWidth = 500;
		startButton.setPrefWidth(btnPrefWidth);
		startEasyButton.setPrefWidth(btnPrefWidth);
		leaderboardButton.setPrefWidth(btnPrefWidth);
		quitButton.setPrefWidth(btnPrefWidth);
		startTimedButton.setPrefWidth(btnPrefWidth);
		startMatch4Button.setPrefWidth(btnPrefWidth);
		startLimitedButton.setPrefWidth(btnPrefWidth);

		Label label = new Label("Sonoran Memory Match");
		label.setPadding(new Insets(50, 0, 50, 0));
		label.setFont(new Font(73));
		label.setTextFill(Color.web("#EEEEEE"));
		GridPane title = new GridPane();
		title.setAlignment(Pos.CENTER);
		title.add(label, 0, 0);

		loginPane.setPadding(new Insets(15, 0, 250, 0));

		this.setTop(title);
		this.setCenter(buttons);
		this.setBottom(loginPane);

		this.setStyle(
				"-fx-background-image: url('file:src/images/desertbackground.jpg')");
	}

	private void registerListeners() {
		startButton.setOnAction(event -> {
			if (this.loginPane.isLoggedIn()) {
				memoryGame.startRound(Mode.NORMAL);
				soundPlayer.playSound("snd_button_click.wav");
				musicPlayer.playSound("snd_gameplaymusic.mp3");
			} else {
				this.loginFirstAlt.show();
			}
		});
		startEasyButton.setOnAction(event -> {
			if (this.loginPane.isLoggedIn()) {
				memoryGame.startRound(Mode.EASY);
				soundPlayer.playSound("snd_button_click.wav");
				musicPlayer.playSound("snd_gameplaymusic.mp3");
			} else {
				this.loginFirstAlt.show();
			}
		});
		startTimedButton.setOnAction(event -> {
			if (this.loginPane.isLoggedIn()) {
				memoryGame.startRound(Mode.TIMED);
				soundPlayer.playSound("snd_button_click.wav");
				musicPlayer.playSound("snd_gameplaymusic.mp3");
			} else {
				this.loginFirstAlt.show();
			}
		});
		startMatch4Button.setOnAction(event -> {
			if (this.loginPane.isLoggedIn()) {
				memoryGame.startRound(Mode.MATCH4);
				soundPlayer.playSound("snd_button_click.wav");
				musicPlayer.playSound("snd_gameplaymusic.mp3");
			} else {
				this.loginFirstAlt.show();
			}
		});
		startLimitedButton.setOnAction(event -> {
			if (this.loginPane.isLoggedIn()) {
				memoryGame.startRound(Mode.LIMITED);
				soundPlayer.playSound("snd_button_click.wav");
				musicPlayer.playSound("snd_gameplaymusic.mp3");
			} else {
				this.loginFirstAlt.show();
			}
		});
		leaderboardButton.setOnAction(event -> {
			if (this.loginPane.isLoggedIn()) {
				memoryGame.showLeaderboard();
				soundPlayer.playSound("snd_button_click.wav");
			} else {
				this.loginFirstAlt.show();
			}
		});
		quitButton.setOnAction(event -> {
			memoryGame.quit();
			soundPlayer.playSound("snd_button_click.wav");
		});

		// Button hover
		startButton.hoverProperty()
				.addListener((ObservableValue<? extends Boolean> obs,
						Boolean unused, Boolean hover) -> {
					if (hover) {
						startButton.setStyle(
								"-fx-background-color: #fdf7ed; -fx-text-fill: black;");
						soundPlayer.playSound("snd_button_hover.wav");
					} else {
						startButton.setStyle(
								"-fx-background-color: #FFEFD5; -fx-text-fill: black;");
					}
				});
		startEasyButton.hoverProperty()
				.addListener((ObservableValue<? extends Boolean> obs,
						Boolean unused, Boolean hover) -> {
					if (hover) {
						startEasyButton.setStyle(
								"-fx-background-color: #fdf7ed; -fx-text-fill: black;");
						soundPlayer.playSound("snd_button_hover.wav");
					} else {
						startEasyButton.setStyle(
								"-fx-background-color: #FFEFD5; -fx-text-fill: black;");
					}
				});
		startTimedButton.hoverProperty()
				.addListener((ObservableValue<? extends Boolean> obs,
						Boolean unused, Boolean hover) -> {
					if (hover) {
						startTimedButton.setStyle(
								"-fx-background-color: #fdf7ed; -fx-text-fill: black;");
						soundPlayer.playSound("snd_button_hover.wav");
					} else {
						startTimedButton.setStyle(
								"-fx-background-color: #FFEFD5; -fx-text-fill: black;");
					}
				});
		startMatch4Button.hoverProperty()
				.addListener((ObservableValue<? extends Boolean> obs,
						Boolean unused, Boolean hover) -> {
					if (hover) {
						startMatch4Button.setStyle(
								"-fx-background-color: #fdf7ed; -fx-text-fill: black;");
						soundPlayer.playSound("snd_button_hover.wav");
					} else {
						startMatch4Button.setStyle(
								"-fx-background-color: #FFEFD5; -fx-text-fill: black;");
					}
				});
		leaderboardButton.hoverProperty()
				.addListener((ObservableValue<? extends Boolean> obs,
						Boolean unused, Boolean hover) -> {
					if (hover) {
						leaderboardButton.setStyle(
								"-fx-background-color: #fdf7ed; -fx-text-fill: black;");
						soundPlayer.playSound("snd_button_hover.wav");
					} else {
						leaderboardButton.setStyle(
								"-fx-background-color: #FFEFD5; -fx-text-fill: black;");
					}
				});
		quitButton.hoverProperty()
				.addListener((ObservableValue<? extends Boolean> obs,
						Boolean unused, Boolean hover) -> {
					if (hover) {
						quitButton.setStyle(
								"-fx-background-color: #fdf7ed; -fx-text-fill: black;");
						soundPlayer.playSound("snd_button_hover.wav");
					} else {
						quitButton.setStyle(
								"-fx-background-color: #FFEFD5; -fx-text-fill: black;");
					}
				});
	}

}
