
import java.util.ArrayList;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import model.Card;
import model.Round;

public class RoundPane extends Application {

	private GridPane pane = new GridPane();
	private Button cacti = new Button("cacti");
	private Button cities = new Button("cities");
	private Button mammals = new Button("mammals");
	private Button mountains = new Button("mountains");
	private Button reptiles = new Button("reptiles");
	private Card nullCard = new Card("null", "null");
	private Label scoreMsg;
	private Card clickedCardOne = nullCard;
	private Card clickedCardTwo = nullCard;
	double firstX;
	double firstY;
	double clickX;
	double clickY;
	private int clickRow;
	private int clickCol;
	private int rowOne;
	private int rowTwo;
	private int colOne;
	private int colTwo;
	private int guessPos;
	private int guessPos1;
	private int guessPos2;
	private boolean firstGuess = true;

//	private CardSet deck;
	private String cardBackPath;
	private Round curRound;

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		chooseDeck();
		layoutGUI();
		setMouseHandler();
		Scene scene = new Scene(pane, 1000, 1000);
		stage.setScene(scene);
		stage.show();

	}

	private void layoutGUI() {
		pane.setHgap(10);
		pane.setVgap(10);
		pane.add(cacti, 0, 0);
		pane.add(cities, 1, 0);
		pane.add(mammals, 2, 0);
		pane.add(mountains, 3, 0);
		pane.add(reptiles, 4, 0);
	}

	private void chooseDeck() {
		cacti.setOnAction(event -> {
			curRound = new Round("cacti", 8);
			cardBackPath = "file:src/images/cardbacks/cardback_cacti.png";
			makeFullDeck();
		});

		cities.setOnAction(event -> {
			curRound = new Round("cities", 8);
			cardBackPath = "file:src/images/cardbacks/cardback_cities.png";
			makeFullDeck();
		});

		mammals.setOnAction(event -> {
			curRound = new Round("mammals", 8);
			cardBackPath = "file:src/images/cardbacks/cardback_mammals.png";
			makeFullDeck();
		});

		mountains.setOnAction(event -> {
			curRound = new Round("mountains", 8);
			cardBackPath = "file:src/images/cardbacks/cardback_mountains.png";
			makeFullDeck();
		});

		reptiles.setOnAction(event -> {
			curRound = new Round("reptiles", 8);
			cardBackPath = "file:src/images/cardbacks/cardback_reptiles.png";
			makeFullDeck();
		});
	}

	private void makeFullDeck() {

		pane.add(new ImageView(new Image(cardBackPath, 150, 200, false, false)),
				0, 1);
		pane.add(new ImageView(new Image(cardBackPath, 150, 200, false, false)),
				1, 1);
		pane.add(new ImageView(new Image(cardBackPath, 150, 200, false, false)),
				2, 1);
		pane.add(new ImageView(new Image(cardBackPath, 150, 200, false, false)),
				3, 1);

		pane.add(new ImageView(new Image(cardBackPath, 150, 200, false, false)),
				0, 2);
		pane.add(new ImageView(new Image(cardBackPath, 150, 200, false, false)),
				1, 2);
		pane.add(new ImageView(new Image(cardBackPath, 150, 200, false, false)),
				2, 2);
		pane.add(new ImageView(new Image(cardBackPath, 150, 200, false, false)),
				3, 2);

		pane.add(new ImageView(new Image(cardBackPath, 150, 200, false, false)),
				0, 3);
		pane.add(new ImageView(new Image(cardBackPath, 150, 200, false, false)),
				1, 3);
		pane.add(new ImageView(new Image(cardBackPath, 150, 200, false, false)),
				2, 3);
		pane.add(new ImageView(new Image(cardBackPath, 150, 200, false, false)),
				3, 3);

		pane.add(new ImageView(new Image(cardBackPath, 150, 200, false, false)),
				0, 4);
		pane.add(new ImageView(new Image(cardBackPath, 150, 200, false, false)),
				1, 4);
		pane.add(new ImageView(new Image(cardBackPath, 150, 200, false, false)),
				2, 4);
		pane.add(new ImageView(new Image(cardBackPath, 150, 200, false, false)),
				3, 4);

		Image cardOneBack = new Image(curRound.getCard(0).getFileName(), 150,
				200, false, false);
		Image cardTwoBack = new Image(curRound.getCard(1).getFileName(), 150,
				200, false, false);
		Image cardThreeBack = new Image(curRound.getCard(2).getFileName(), 150,
				200, false, false);
		Image cardFourBack = new Image(curRound.getCard(3).getFileName(), 150,
				200, false, false);
		Image cardFiveBack = new Image(curRound.getCard(4).getFileName(), 150,
				200, false, false);
		Image cardSixBack = new Image(curRound.getCard(5).getFileName(), 150,
				200, false, false);
		Image cardSevenBack = new Image(curRound.getCard(6).getFileName(), 150,
				200, false, false);
		Image cardEightBack = new Image(curRound.getCard(7).getFileName(), 150,
				200, false, false);
		Image cardNineBack = new Image(curRound.getCard(8).getFileName(), 150,
				200, false, false);
		Image cardTenBack = new Image(curRound.getCard(9).getFileName(), 150,
				200, false, false);
		Image cardElevenBack = new Image(curRound.getCard(10).getFileName(),
				150, 200, false, false);
		Image cardTwelveBack = new Image(curRound.getCard(11).getFileName(),
				150, 200, false, false);
		Image cardThirteenBack = new Image(curRound.getCard(12).getFileName(),
				150, 200, false, false);
		Image cardFourteenBack = new Image(curRound.getCard(13).getFileName(),
				150, 200, false, false);
		Image cardFifteenBack = new Image(curRound.getCard(14).getFileName(),
				150, 200, false, false);
		Image cardSixteenBack = new Image(curRound.getCard(15).getFileName(),
				150, 200, false, false);
	}

	private void setMouseHandler() {
		pane.setOnMouseClicked(event -> {

			if (firstGuess) {
				firstGuess = false;
				clickedCardOne = getClickedCard(event);
				rowOne = clickRow;
				colOne = clickCol;
				guessPos1 = guessPos;
				pane.add(new ImageView(new Image(clickedCardOne.getFileName(),
						150, 200, false, false)), clickCol, clickRow);
			} else {
				firstGuess = true;
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				checkCards();
			}

		});

		pane.setOnMousePressed(event -> {

			clickedCardTwo = getClickedCard(event);
			rowTwo = clickRow;
			colTwo = clickCol;
			guessPos2 = guessPos;
			pane.add(new ImageView(new Image(clickedCardTwo.getFileName(), 150,
					200, false, false)), clickCol, clickRow);
		});

	}

	private Card getClickedCard(MouseEvent event) {
		Card clickedCard = null;
		double clickX = event.getX();
		double clickY = event.getY();
		
		// row one
		if (clickY >= 41 && clickY <= 233) {
			clickRow = 1;
			// cardOne
			if (clickX >= 12 && clickX <= 145) {
				clickCol = 0;
				clickedCard = curRound.getCard(0);
				guessPos = 0;
				// cardTwo
			} else if (clickX >= 166 && clickX <= 299) {
				clickCol = 1;
				clickedCard = curRound.getCard(1);
				guessPos = 1;
				// cardThree
			} else if (clickX >= 328 && clickX <= 464) {
				clickCol = 2;
				clickedCard = curRound.getCard(2);
				guessPos = 2;
				// cardFour
			} else if (clickX >= 489 && clickX <= 625) {
				clickCol = 3;
				clickedCard = curRound.getCard(3);
				guessPos = 3;
			}
		}

		// row two
		if (clickY >= 251 && clickY <= 440) {
			clickRow = 2;
			// cardFive
			if (clickX >= 12 && clickX <= 145) {
				clickCol = 0;
				clickedCard = curRound.getCard(4);
				guessPos = 4;
				// cardSix
			} else if (clickX >= 166 && clickX <= 300) {
				clickCol = 1;
				clickedCard = curRound.getCard(5);
				guessPos = 5;
				// cardSeven
			} else if (clickX >= 326 && clickX <= 464) {
				clickCol = 2;
				clickedCard = curRound.getCard(6);
				guessPos = 6;
				// cardEight
			} else if (clickX >= 485 && clickX <= 625) {
				clickCol = 3;
				clickedCard = curRound.getCard(7);
				guessPos = 7;
			}
		}

		// row three
		if (clickY >= 460 && clickY <= 652) {
			clickRow = 3;
			// cardNine
			if (clickX >= 12 && clickX <= 145) {
				clickCol = 0;
				clickedCard = curRound.getCard(8);
				guessPos = 8;
				// cardTen
			} else if (clickX >= 166 && clickX <= 300) {
				clickCol = 1;
				clickedCard = curRound.getCard(9);
				guessPos = 9;
				// cardEleven
			} else if (clickX >= 326 && clickX <= 464) {
				clickCol = 2;
				clickedCard = curRound.getCard(10);
				guessPos = 10;
				// cardTwelve
			} else if (clickX >= 485 && clickX <= 625) {
				clickCol = 3;
				clickedCard = curRound.getCard(11);
				guessPos = 11;
			}

		}

		// row four
		if (clickY >= 669 && clickY <= 864) {
			clickRow = 4;
			// cardThirteen
			if (clickX >= 12 && clickX <= 145) {
				clickCol = 0;
				clickedCard = curRound.getCard(12);
				guessPos = 12;
				// cardFourteen
			} else if (clickX >= 166 && clickX <= 300) {
				clickCol = 1;
				clickedCard = curRound.getCard(13);
				guessPos = 13;
				// cardFifteen
			} else if (clickX >= 326 && clickX <= 464) {
				clickCol = 2;
				clickedCard = curRound.getCard(14);
				guessPos = 14;
				// cardSixteen
			} else if (clickX >= 485 && clickX <= 625) {
				clickCol = 3;
				clickedCard = curRound.getCard(15);
				guessPos = 15;
			}
		}

		return clickedCard;
	}

	private void checkCards() {
		if (curRound.isActive()) {

			if (!clickedCardOne.equals(nullCard)
					&& !clickedCardTwo.equals(nullCard)) {
				curRound.makeGuess(guessPos1, guessPos2);
				// see if cards match
				if (clickedCardOne.getName().equals(clickedCardTwo.getName())) {
					Rectangle rectOne = new Rectangle();
					rectOne.setWidth(150);
					rectOne.setHeight(200);
					rectOne.setFill(Color.WHITE);

					Rectangle rectTwo = new Rectangle();
					rectTwo.setWidth(150);
					rectTwo.setHeight(200);
					rectTwo.setFill(Color.WHITE);

					pane.add(rectOne, colOne, rowOne);
					pane.add(rectTwo, colTwo, rowTwo);
					clickedCardOne = nullCard;
					clickedCardTwo = nullCard;

				} else {
					pane.add(new ImageView(
							new Image(cardBackPath, 150, 200, false, false)),
							colOne, rowOne);
					pane.add(new ImageView(
							new Image(cardBackPath, 150, 200, false, false)),
							colTwo, rowTwo);
					clickedCardOne = nullCard;
					clickedCardTwo = nullCard;
				}
			}
		}

		if(!curRound.isActive()) {
			String score = curRound.getScore().toString();
			System.out.println("Game finished");
			scoreMsg = new Label("Your score: " + score);
			pane.add(scoreMsg, 0, 4);
		}
	}

}
