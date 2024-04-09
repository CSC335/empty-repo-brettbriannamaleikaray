// @author Maleika Fleming

import java.util.ArrayList;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class RoundPane extends Application {

	private BorderPane roundPane = new BorderPane();
	private GridPane pane = new GridPane();
	private CardSet deck = null;
	private ArrayList<Image> cards = new ArrayList<Image>();
	private String cardBackPath;
	private boolean firstClick = true;
	private boolean makeGuess = false;

	private Button cacti = new Button("cacti");
	private Button cities = new Button("cities");
	private Button mammals = new Button("mammals");
	private Button mountains = new Button("mountains");
	private Button reptiles = new Button("reptiles");
	private Card clickedCardOne;
	private Card clickedCardTwo;
	private double firstX;
	private double firstY;
	private double secondX;
	private double secondY;
	private int rowOne;
	private int rowTwo;
	private int colOne;
	private int colTwo;

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		chooseDeck(stage);
		layoutGUI();
		setMouseHandlers();
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

	private void chooseDeck(Stage stage) {
		cacti.setOnAction(event -> {
			deck = new CardSet("cacti");
			cardBackPath = "file:src/images/cardbacks/cardback_cacti.png";
			makeFullDeck();
		});

		cities.setOnAction(event -> {
			deck = new CardSet("cities");
			cardBackPath = "file:src/images/cardbacks/cardback_cities.png";
			makeFullDeck();
		});

		mammals.setOnAction(event -> {
			deck = new CardSet("mammals");
			cardBackPath = "file:src/images/cardbacks/cardback_mammals.png";
			makeFullDeck();
		});

		mountains.setOnAction(event -> {
			deck = new CardSet("mountains");
			cardBackPath = "file:src/images/cardbacks/cardback_mountains.png";
			makeFullDeck();
		});

		reptiles.setOnAction(event -> {
			deck = new CardSet("reptiles");
			cardBackPath = "file:src/images/cardbacks/cardback_reptiles.png";
			makeFullDeck();
		});
	}

	// make duplicate of each card so there are pairs
	// and set the front and back image of each card
	private void makeFullDeck() {
		for (int i = 0; i < 8; i++) {
			Card currentCard = deck.getCard(i);
			deck.addCard(currentCard);
		}
		deck.shuffleCards();

		Image cardOne = new Image(cardBackPath, 150, 200, false, false);
		Image cardTwo = new Image(cardBackPath, 150, 200, false, false);
		Image cardThree = new Image(cardBackPath, 150, 200, false, false);
		Image cardFour = new Image(cardBackPath, 150, 200, false, false);
		Image cardFive = new Image(cardBackPath, 150, 200, false, false);
		Image cardSix = new Image(cardBackPath, 150, 200, false, false);
		Image cardSeven = new Image(cardBackPath, 150, 200, false, false);
		Image cardEight = new Image(cardBackPath, 150, 200, false, false);
		Image cardNine = new Image(cardBackPath, 150, 200, false, false);
		Image cardTen = new Image(cardBackPath, 150, 200, false, false);
		Image cardEleven = new Image(cardBackPath, 150, 200, false, false);
		Image cardTwelve = new Image(cardBackPath, 150, 200, false, false);
		Image cardThirteen = new Image(cardBackPath, 150, 200, false, false);
		Image cardFourteen = new Image(cardBackPath, 150, 200, false, false);
		Image cardFifteen = new Image(cardBackPath, 150, 200, false, false);
		Image cardSixteen = new Image(cardBackPath, 150, 200, false, false);

		cards.add(cardOne);
		cards.add(cardTwo);
		cards.add(cardThree);
		cards.add(cardFour);
		cards.add(cardFive);
		cards.add(cardSix);
		cards.add(cardSeven);
		cards.add(cardEight);
		cards.add(cardNine);
		cards.add(cardTen);
		cards.add(cardEleven);
		cards.add(cardTwelve);
		cards.add(cardThirteen);
		cards.add(cardFourteen);
		cards.add(cardFifteen);
		cards.add(cardSixteen);

		pane.add(new ImageView(cardOne), 0, 1);
		pane.add(new ImageView(cardTwo), 1, 1);
		pane.add(new ImageView(cardThree), 2, 1);
		pane.add(new ImageView(cardFour), 3, 1);

		pane.add(new ImageView(cardFive), 0, 2);
		pane.add(new ImageView(cardSix), 1, 2);
		pane.add(new ImageView(cardSeven), 2, 2);
		pane.add(new ImageView(cardEight), 3, 2);

		pane.add(new ImageView(cardNine), 0, 3);
		pane.add(new ImageView(cardTen), 1, 3);
		pane.add(new ImageView(cardEleven), 2, 3);
		pane.add(new ImageView(cardTwelve), 3, 3);

		pane.add(new ImageView(cardThirteen), 0, 4);
		pane.add(new ImageView(cardFourteen), 1, 4);
		pane.add(new ImageView(cardFifteen), 2, 4);
		pane.add(new ImageView(cardSixteen), 3, 4);

		Image cardOneBack = new Image(deck.getCard(0).getFileName(), 150, 200, false, false);
		Image cardTwoBack = new Image(deck.getCard(1).getFileName(), 150, 200, false, false);
		Image cardThreeBack = new Image(deck.getCard(2).getFileName(), 150, 200, false, false);
		Image cardFourBack = new Image(deck.getCard(3).getFileName(), 150, 200, false, false);
		Image cardFiveBack = new Image(deck.getCard(4).getFileName(), 150, 200, false, false);
		Image cardSixBack = new Image(deck.getCard(5).getFileName(), 150, 200, false, false);
		Image cardSevenBack = new Image(deck.getCard(6).getFileName(), 150, 200, false, false);
		Image cardEightBack = new Image(deck.getCard(7).getFileName(), 150, 200, false, false);
		Image cardNineBack = new Image(deck.getCard(8).getFileName(), 150, 200, false, false);
		Image cardTenBack = new Image(deck.getCard(9).getFileName(), 150, 200, false, false);
		Image cardElevenBack = new Image(deck.getCard(10).getFileName(), 150, 200, false, false);
		Image cardTwelveBack = new Image(deck.getCard(11).getFileName(), 150, 200, false, false);
		Image cardThirteenBack = new Image(deck.getCard(12).getFileName(), 150, 200, false, false);
		Image cardFourteenBack = new Image(deck.getCard(13).getFileName(), 150, 200, false, false);
		Image cardFifteenBack = new Image(deck.getCard(14).getFileName(), 150, 200, false, false);
		Image cardSixteenBack = new Image(deck.getCard(15).getFileName(), 150, 200, false, false);

	}

	private void setMouseHandlers() {

		// first card
		pane.setOnMouseClicked(event -> {
			if (firstClick) {
				makeGuess = true;
				firstClick = false;

				firstX = event.getX();
				firstY = event.getY();

				// row one
				if (firstY >= 41 && firstY <= 233) {
					rowOne = 1;
					// cardOne
					if (firstX >= 12 && firstX <= 145) {
						pane.add(new ImageView(new Image(deck.getCard(0).getFileName(), 150, 200, false, false)), 0, 1);
						colOne = 0;
						clickedCardOne = deck.getCard(0);
						// cardTwo
					} else if (firstX >= 166 && firstX <= 299) {
						pane.add(new ImageView(new Image(deck.getCard(1).getFileName(), 150, 200, false, false)), 1, 1);
						colOne = 1;
						clickedCardOne = deck.getCard(1);
						// cardThree
					} else if (firstX >= 328 && firstX <= 464) {
						pane.add(new ImageView(new Image(deck.getCard(2).getFileName(), 150, 200, false, false)), 2, 1);
						colOne = 2;
						clickedCardOne = deck.getCard(2);
						// cardFour
					} else if (firstX >= 489 && firstX <= 625) {
						pane.add(new ImageView(new Image(deck.getCard(3).getFileName(), 150, 200, false, false)), 3, 1);
						colOne = 3;
						clickedCardOne = deck.getCard(3);
					}
				}

				// row two
				if (firstY >= 251 && firstY <= 440) {
					rowOne = 2;
					// cardFive
					if (firstX >= 12 && firstX <= 145) {
						pane.add(new ImageView(new Image(deck.getCard(4).getFileName(), 150, 200, false, false)), 0, 2);
						colOne = 0;
						clickedCardOne = deck.getCard(4);
						// cardSix
					} else if (firstX >= 166 && firstX <= 300) {
						pane.add(new ImageView(new Image(deck.getCard(5).getFileName(), 150, 200, false, false)), 1, 2);
						colOne = 1;
						clickedCardOne = deck.getCard(5);
						// cardSeven
					} else if (firstX >= 326 && firstX <= 464) {
						pane.add(new ImageView(new Image(deck.getCard(6).getFileName(), 150, 200, false, false)), 2, 2);
						colOne = 2;
						clickedCardOne = deck.getCard(6);
						// cardEight
					} else if (firstX >= 485 && firstX <= 625) {
						pane.add(new ImageView(new Image(deck.getCard(7).getFileName(), 150, 200, false, false)), 3, 2);
						colOne = 3;
						clickedCardOne = deck.getCard(7);
					}
				}

				// row three
				if (firstY >= 460 && firstY <= 652) {
					rowOne = 3;
					// cardNine
					if (firstX >= 12 && firstX <= 145) {
						pane.add(new ImageView(new Image(deck.getCard(8).getFileName(), 150, 200, false, false)), 0, 3);
						colOne = 0;
						clickedCardOne = deck.getCard(8);
						// cardTen
					} else if (firstX >= 166 && firstX <= 300) {
						pane.add(new ImageView(new Image(deck.getCard(9).getFileName(), 150, 200, false, false)), 1, 3);
						colOne = 1;
						clickedCardOne = deck.getCard(9);
						// cardEleven
					} else if (firstX >= 326 && firstX <= 464) {
						pane.add(new ImageView(new Image(deck.getCard(10).getFileName(), 150, 200, false, false)), 2,
								3);
						colOne = 2;
						clickedCardOne = deck.getCard(10);
						// cardTwelve
					} else if (firstX >= 485 && firstX <= 625) {
						pane.add(new ImageView(new Image(deck.getCard(11).getFileName(), 150, 200, false, false)), 3,
								3);
						colOne = 3;
						clickedCardOne = deck.getCard(11);
					}

				}

				// row four
				if (firstY >= 669 && firstY <= 864) {
					rowOne = 4;
					// cardThirteen
					if (firstX >= 12 && firstX <= 145) {
						pane.add(new ImageView(new Image(deck.getCard(12).getFileName(), 150, 200, false, false)), 0,
								4);
						colOne = 0;
						clickedCardOne = deck.getCard(12);
						// cardFourteen
					} else if (firstX >= 166 && firstX <= 300) {
						pane.add(new ImageView(new Image(deck.getCard(13).getFileName(), 150, 200, false, false)), 1,
								4);
						colOne = 1;
						clickedCardOne = deck.getCard(13);
						// cardFifteen
					} else if (firstX >= 326 && firstX <= 464) {
						pane.add(new ImageView(new Image(deck.getCard(14).getFileName(), 150, 200, false, false)), 2,
								4);
						colOne = 2;
						clickedCardOne = deck.getCard(14);
						// cardSixteen
					} else if (firstX >= 485 && firstX <= 625) {
						pane.add(new ImageView(new Image(deck.getCard(15).getFileName(), 150, 200, false, false)), 3,
								4);
						colOne = 3;
						clickedCardOne = deck.getCard(15);
					}
				}

			} else {
				firstClick = true;
				makeGuess = false;
				secondX = event.getX();
				secondY = event.getY();

				// row one
				if (secondY >= 41 && secondY <= 233) {
					rowTwo = 1;
					// cardOne
					if (secondX >= 12 && secondX <= 145) {
						pane.add(new ImageView(new Image(deck.getCard(0).getFileName(), 150, 200, false, false)), 0, 1);
						colTwo = 0;
						clickedCardTwo = deck.getCard(0);
						// cardTwo
					} else if (secondX >= 166 && secondX <= 299) {
						pane.add(new ImageView(new Image(deck.getCard(1).getFileName(), 150, 200, false, false)), 1, 1);
						colTwo = 1;
						clickedCardTwo = deck.getCard(1);
						// cardThree
					} else if (secondX >= 328 && secondX <= 464) {
						pane.add(new ImageView(new Image(deck.getCard(2).getFileName(), 150, 200, false, false)), 2, 1);
						colTwo = 2;
						clickedCardTwo = deck.getCard(2);
						// cardFour
					} else if (secondX >= 489 && secondX <= 625) {
						pane.add(new ImageView(new Image(deck.getCard(3).getFileName(), 150, 200, false, false)), 3, 1);
						colTwo = 3;
						clickedCardTwo = deck.getCard(3);
					}
				}

				// row two
				if (secondY >= 251 && secondY <= 440) {
					rowTwo = 2;
					// cardFive
					if (secondX >= 12 && secondX <= 145) {
						pane.add(new ImageView(new Image(deck.getCard(4).getFileName(), 150, 200, false, false)), 0, 2);
						colTwo = 0;
						clickedCardTwo = deck.getCard(4);
						// cardSix
					} else if (secondX >= 166 && secondX <= 300) {
						pane.add(new ImageView(new Image(deck.getCard(5).getFileName(), 150, 200, false, false)), 1, 2);
						colTwo = 1;
						clickedCardTwo = deck.getCard(5);
						// cardSeven
					} else if (secondX >= 326 && secondX <= 464) {
						pane.add(new ImageView(new Image(deck.getCard(6).getFileName(), 150, 200, false, false)), 2, 2);
						colTwo = 2;
						clickedCardTwo = deck.getCard(6);
						// cardEight
					} else if (secondX >= 485 && secondX <= 625) {
						pane.add(new ImageView(new Image(deck.getCard(7).getFileName(), 150, 200, false, false)), 3, 2);
						colTwo = 3;
						clickedCardTwo = deck.getCard(7);
					}
				}

				// row three
				if (secondY >= 460 && secondY <= 652) {
					rowTwo = 3;
					// cardNine
					if (secondX >= 12 && secondX <= 145) {
						pane.add(new ImageView(new Image(deck.getCard(8).getFileName(), 150, 200, false, false)), 0, 3);
						colTwo = 0;
						clickedCardTwo = deck.getCard(8);
						// cardTen
					} else if (secondX >= 166 && secondX <= 300) {
						pane.add(new ImageView(new Image(deck.getCard(9).getFileName(), 150, 200, false, false)), 1, 3);
						colTwo = 1;
						clickedCardTwo = deck.getCard(9);
						// cardEleven
					} else if (secondX >= 326 && secondX <= 464) {
						pane.add(new ImageView(new Image(deck.getCard(10).getFileName(), 150, 200, false, false)), 2,
								3);
						colTwo = 2;
						clickedCardTwo = deck.getCard(10);
						// cardTwelve
					} else if (secondX >= 485 && secondX <= 625) {
						pane.add(new ImageView(new Image(deck.getCard(11).getFileName(), 150, 200, false, false)), 3,
								3);
						colTwo = 3;
						clickedCardTwo = deck.getCard(11);
					}

				}

				// row four
				if (secondY >= 669 && secondY <= 864) {
					rowTwo = 4;
					// cardThirteen
					if (secondX >= 12 && secondX <= 145) {
						pane.add(new ImageView(new Image(deck.getCard(12).getFileName(), 150, 200, false, false)), 0,
								4);
						colTwo = 0;
						clickedCardTwo = deck.getCard(12);
						// cardFourteen
					} else if (secondX >= 166 && secondX <= 300) {
						pane.add(new ImageView(new Image(deck.getCard(13).getFileName(), 150, 200, false, false)), 1,
								4);
						colTwo = 1;
						clickedCardTwo = deck.getCard(13);
						// cardFifteen
					} else if (secondX >= 326 && secondX <= 464) {
						pane.add(new ImageView(new Image(deck.getCard(14).getFileName(), 150, 200, false, false)), 2,
								4);
						colTwo = 2;
						clickedCardTwo = deck.getCard(14);
						// cardSixteen
					} else if (secondX >= 485 && secondX <= 625) {
						pane.add(new ImageView(new Image(deck.getCard(15).getFileName(), 150, 200, false, false)), 3,
								4);
						colTwo = 3;
						clickedCardTwo = deck.getCard(15);
					}
				}

				// show cards for 3 seconds
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

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
				} else {
					pane.add(new ImageView(new Image(cardBackPath, 150, 200, false, false)), colOne, rowOne);
					pane.add(new ImageView(new Image(cardBackPath, 150, 200, false, false)), colTwo, rowTwo);
				}
			}
		});

	}

}
