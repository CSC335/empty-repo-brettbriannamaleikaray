
import java.util.ArrayList;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class RoundPane extends Application {

	private GridPane pane = new GridPane();
	private Button cacti = new Button("cacti");
	private Button cities = new Button("cities");
	private Button mammals = new Button("mammals");
	private Button mountains = new Button("mountains");
	private Button reptiles = new Button("reptiles");
	private Card nullCard = new Card("null", "null");
	private Card clickedCardOne = nullCard;
	private Card clickedCardTwo = nullCard;
	double firstX;
	double firstY;
	double secondX;
	double secondY;
	private int rowOne;
	private int colOne;
	private int rowTwo;
	private int colTwo;
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

		pane.add(new ImageView(new Image(cardBackPath, 150, 200, false, false)), 0, 1);
		pane.add(new ImageView(new Image(cardBackPath, 150, 200, false, false)), 1, 1);
		pane.add(new ImageView(new Image(cardBackPath, 150, 200, false, false)), 2, 1);
		pane.add(new ImageView(new Image(cardBackPath, 150, 200, false, false)), 3, 1);

		pane.add(new ImageView(new Image(cardBackPath, 150, 200, false, false)), 0, 2);
		pane.add(new ImageView(new Image(cardBackPath, 150, 200, false, false)), 1, 2);
		pane.add(new ImageView(new Image(cardBackPath, 150, 200, false, false)), 2, 2);
		pane.add(new ImageView(new Image(cardBackPath, 150, 200, false, false)), 3, 2);

		pane.add(new ImageView(new Image(cardBackPath, 150, 200, false, false)), 0, 3);
		pane.add(new ImageView(new Image(cardBackPath, 150, 200, false, false)), 1, 3);
		pane.add(new ImageView(new Image(cardBackPath, 150, 200, false, false)), 2, 3);
		pane.add(new ImageView(new Image(cardBackPath, 150, 200, false, false)), 3, 3);

		pane.add(new ImageView(new Image(cardBackPath, 150, 200, false, false)), 0, 4);
		pane.add(new ImageView(new Image(cardBackPath, 150, 200, false, false)), 1, 4);
		pane.add(new ImageView(new Image(cardBackPath, 150, 200, false, false)), 2, 4);
		pane.add(new ImageView(new Image(cardBackPath, 150, 200, false, false)), 3, 4);

		Image cardOneBack = new Image(curRound.getCard(0).getFileName(), 150, 200, false, false);
		Image cardTwoBack = new Image(curRound.getCard(1).getFileName(), 150, 200, false, false);
		Image cardThreeBack = new Image(curRound.getCard(2).getFileName(), 150, 200, false, false);
		Image cardFourBack = new Image(curRound.getCard(3).getFileName(), 150, 200, false, false);
		Image cardFiveBack = new Image(curRound.getCard(4).getFileName(), 150, 200, false, false);
		Image cardSixBack = new Image(curRound.getCard(5).getFileName(), 150, 200, false, false);
		Image cardSevenBack = new Image(curRound.getCard(6).getFileName(), 150, 200, false, false);
		Image cardEightBack = new Image(curRound.getCard(7).getFileName(), 150, 200, false, false);
		Image cardNineBack = new Image(curRound.getCard(8).getFileName(), 150, 200, false, false);
		Image cardTenBack = new Image(curRound.getCard(9).getFileName(), 150, 200, false, false);
		Image cardElevenBack = new Image(curRound.getCard(10).getFileName(), 150, 200, false, false);
		Image cardTwelveBack = new Image(curRound.getCard(11).getFileName(), 150, 200, false, false);
		Image cardThirteenBack = new Image(curRound.getCard(12).getFileName(), 150, 200, false, false);
		Image cardFourteenBack = new Image(curRound.getCard(13).getFileName(), 150, 200, false, false);
		Image cardFifteenBack = new Image(curRound.getCard(14).getFileName(), 150, 200, false, false);
		Image cardSixteenBack = new Image(curRound.getCard(15).getFileName(), 150, 200, false, false);
	}

	private void setMouseHandler() {
		pane.setOnMouseClicked(event -> {

			if (firstGuess) {
				firstGuess = false;
				firstX = event.getX();
				firstY = event.getY();

				// row one
				if (firstY >= 41 && firstY <= 233) {
					rowOne = 1;
					// cardOne
					if (firstX >= 12 && firstX <= 145) {
						colOne = 0;
						clickedCardOne = curRound.getCard(0);
						// cardTwo
					} else if (firstX >= 166 && firstX <= 299) {
						colOne = 1;
						clickedCardOne = curRound.getCard(1);
						// cardThree
					} else if (firstX >= 328 && firstX <= 464) {
						colOne = 2;
						clickedCardOne = curRound.getCard(2);
						// cardFour
					} else if (firstX >= 489 && firstX <= 625) {
						colOne = 3;
						clickedCardOne = curRound.getCard(3);
					}
				}

				// row two
				if (firstY >= 251 && firstY <= 440) {
					rowOne = 2;
					// cardFive
					if (firstX >= 12 && firstX <= 145) {
						colOne = 0;
						clickedCardOne = curRound.getCard(4);
						// cardSix
					} else if (firstX >= 166 && firstX <= 300) {
						colOne = 1;
						clickedCardOne = curRound.getCard(5);
						// cardSeven
					} else if (firstX >= 326 && firstX <= 464) {
						colOne = 2;
						clickedCardOne = curRound.getCard(6);
						// cardEight
					} else if (firstX >= 485 && firstX <= 625) {
						colOne = 3;
						clickedCardOne = curRound.getCard(7);
					}
				}

				// row three
				if (firstY >= 460 && firstY <= 652) {
					rowOne = 3;
					// cardNine
					if (firstX >= 12 && firstX <= 145) {
						clickedCardOne = curRound.getCard(8);
						colOne = 0;
						// cardTen
					} else if (firstX >= 166 && firstX <= 300) {
						clickedCardOne = curRound.getCard(9);
						colOne = 1;
						// cardEleven
					} else if (firstX >= 326 && firstX <= 464) {
						colOne = 2;
						clickedCardOne = curRound.getCard(10);
						// cardTwelve
					} else if (firstX >= 485 && firstX <= 625) {
						colOne = 3;
						clickedCardOne = curRound.getCard(11);
					}

				}

				// row four
				if (firstY >= 669 && firstY <= 864) {
					rowOne = 4;
					// cardThirteen
					if (firstX >= 12 && firstX <= 145) {
						colOne = 0;
						clickedCardOne = curRound.getCard(12);
						// cardFourteen
					} else if (firstX >= 166 && firstX <= 300) {
						colOne = 1;
						clickedCardOne = curRound.getCard(13);
						// cardFifteen
					} else if (firstX >= 326 && firstX <= 464) {
						colOne = 2;
						clickedCardOne = curRound.getCard(14);
						// cardSixteen
					} else if (firstX >= 485 && firstX <= 625) {
						colOne = 3;
						clickedCardOne = curRound.getCard(15);
					}
				}

				pane.add(new ImageView(new Image(clickedCardOne.getFileName(), 150, 200, false, false)), colOne,
						rowOne);
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

			secondX = event.getX();
			secondY = event.getY();

			// row one
			if (secondY >= 41 && secondY <= 233) {
				rowTwo = 1;
				// cardOne
				if (secondX >= 12 && secondX <= 145) {
					colTwo = 0;
					clickedCardTwo = curRound.getCard(0);
					// cardTwo
				} else if (secondX >= 166 && secondX <= 299) {
					colTwo = 1;
					clickedCardTwo = curRound.getCard(1);
					// cardThree
				} else if (secondX >= 328 && secondX <= 464) {
					colTwo = 2;
					clickedCardTwo = curRound.getCard(2);
					// cardFour
				} else if (secondX >= 489 && secondX <= 625) {
					colTwo = 3;
					clickedCardTwo = curRound.getCard(3);
				}
			}

			// row two
			if (secondY >= 251 && secondY <= 440) {
				rowTwo = 2;
				// cardFive
				if (secondX >= 12 && secondX <= 145) {
					colTwo = 0;
					clickedCardTwo = curRound.getCard(4);
					// cardSix
				} else if (secondX >= 166 && secondX <= 300) {
					colTwo = 1;
					clickedCardTwo = curRound.getCard(5);
					// cardSeven
				} else if (secondX >= 326 && secondX <= 464) {
					colTwo = 2;
					clickedCardTwo = curRound.getCard(6);
					// cardEight
				} else if (secondX >= 485 && secondX <= 625) {
					colTwo = 3;
					clickedCardTwo = curRound.getCard(7);
				}
			}

			// row three
			if (secondY >= 460 && secondY <= 652) {
				rowTwo = 3;
				// cardNine
				if (secondX >= 12 && secondX <= 145) {
					colTwo = 0;
					clickedCardTwo = curRound.getCard(8);
					// cardTen
				} else if (secondX >= 166 && secondX <= 300) {
					colTwo = 1;
					clickedCardTwo = curRound.getCard(9);
					// cardEleven
				} else if (secondX >= 326 && secondX <= 464) {
					colTwo = 2;
					clickedCardTwo = curRound.getCard(10);
					// cardTwelve
				} else if (secondX >= 485 && secondX <= 625) {
					colTwo = 3;
					clickedCardTwo = curRound.getCard(11);
				}

			}

			// row four
			if (secondY >= 669 && secondY <= 864) {
				rowTwo = 4;
				// cardThirteen
				if (secondX >= 12 && secondX <= 145) {
					colTwo = 0;
					clickedCardTwo = curRound.getCard(12);
					// cardFourteen
				} else if (secondX >= 166 && secondX <= 300) {
					colTwo = 1;
					clickedCardTwo = curRound.getCard(13);
					// cardFifteen
				} else if (secondX >= 326 && secondX <= 464) {
					colTwo = 2;
					clickedCardTwo = curRound.getCard(14);
					// cardSixteen
				} else if (secondX >= 485 && secondX <= 625) {
					colTwo = 3;
					clickedCardTwo = curRound.getCard(15);
				}
			}

			pane.add(new ImageView(new Image(clickedCardTwo.getFileName(), 150, 200, false, false)), colTwo, rowTwo);

		});

	}

	private void checkCards() {

		if (!clickedCardOne.equals(nullCard) && !clickedCardTwo.equals(nullCard)) {

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
				pane.add(new ImageView(new Image(cardBackPath, 150, 200, false, false)), colOne, rowOne);
				pane.add(new ImageView(new Image(cardBackPath, 150, 200, false, false)), colTwo, rowTwo);
				clickedCardOne = nullCard;
				clickedCardTwo = nullCard;
			}
		}
	}


}
