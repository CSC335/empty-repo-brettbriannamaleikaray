
import java.util.ArrayList;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
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
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import model.Card;
import model.Round;

/**
 *  Starts a new Round of the Memory Game. It first shows 5
 *  card backs that represent a different theme. Once a card back
 *  is chosen a new deck is shown and the game begins. As the game
 *  is played the number of guesses and a score is kept. Once all 
 *  the card pairs have been found the round ends.
 */
public class RoundPane extends GridPane {
	
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
	private Label[] textLabels = new Label[16];
	private ImageView cacti;
	private ImageView cities;
	private ImageView mammals;
	private ImageView mountains;
	private ImageView reptiles;
	private boolean gameStarted = false;
	private Label stats = new Label("guesses: 0\n score: 0");
	private int guessCount = 0;
	private int scoreCount = 0;

//	private CardSet deck;
	private String cardBackPath;
	private Round curRound;
	private MemoryGameGUI memoryGame;
	
	
	/** 
	 *  Constructs a new RoundPane
	 * 
	 * @param memoryGame The MemoryGameGUI object that controls the GUI
	 */
	public RoundPane(MemoryGameGUI memoryGame) {
		this.memoryGame = memoryGame;
		layoutGUI();
		setMouseHandler();

		// Load CSS for text labels
		this.getStylesheets().addAll(getClass().getResource("TextOutline.css").toExternalForm());
	}

	private void layoutGUI() {

		this.setHgap(10);
		this.setVgap(10);
		this.setAlignment(Pos.CENTER);

		cacti = new ImageView(new Image("file:src/images/cardbacks/cardback_cacti.png", 125, 175, false, false));
		cities = new ImageView(new Image("file:src/images/cardbacks/cardback_cities.png", 125, 175, false, false));
		mammals = new ImageView(new Image("file:src/images/cardbacks/cardback_mammals.png", 125, 175, false, false));
		mountains = new ImageView(
				new Image("file:src/images/cardbacks/cardback_mountains.png", 125, 175, false, false));
		reptiles = new ImageView(new Image("file:src/images/cardbacks/cardback_reptiles.png", 125, 175, false, false));

		this.add(cacti, 0, 0);
		this.add(cities, 1, 0);
		this.add(mammals, 2, 0);
		this.add(mountains, 3, 0);
		this.add(reptiles, 4, 0);

		// cacti chosen
		cacti.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {

			/**
			 * Handler for if the cacti card back is clicked. Starts a new
			 * round with the cacti deck and sets the cardBackPath to the
			 * cacti images. Then calls a private method to create a full
			 * deck of cacti cards.
			 * @param event MouseEvent for if cacti card is clicked
			 */
			@Override
			public void handle(MouseEvent event) {
				curRound = new Round("cacti", 8);
				cardBackPath = "file:src/images/cardbacks/cardback_cacti.png";
				makeFullDeck();
			}

		});

		// cities chosen
		cities.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {

			/**
			 * Handler for if the cities card back is clicked. Starts a new
			 * round with the cities deck and sets the cardBackPath to the
			 * city images. Then calls a private method to create a full
			 * deck of city cards.
			 * @param event MouseEvent for if cities card is clicked
			 */
			@Override
			public void handle(MouseEvent event) {
				curRound = new Round("cities", 8);
				cardBackPath = "file:src/images/cardbacks/cardback_cities.png";
				makeFullDeck();
			}

		});

		// mammals chosen
		mammals.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {

			/**
			 * Handler for if the mammals card back is clicked. Starts a new
			 * round with the mammals deck and sets the cardBackPath to the
			 * mammal images. Then calls a private method to create a full
			 * deck of mammals cards.
			 * @param event MouseEvent for if mammals card is clicked
			 */
			@Override
			public void handle(MouseEvent event) {
				curRound = new Round("mammals", 8);
				cardBackPath = "file:src/images/cardbacks/cardback_mammals.png";
				makeFullDeck();
			}

		});

		// mountains chosen
		mountains.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {

			/**
			 * Handler for if the mountains card back is clicked. Starts a new
			 * round with the mountains deck and sets the cardBackPath to the
			 * mountain images. Then calls a private method to create a full
			 * deck of mountains cards.
			 * @param event MouseEvent for if mountanis card is clicked
			 */
			@Override
			public void handle(MouseEvent event) {
				curRound = new Round("mountains", 8);
				cardBackPath = "file:src/images/cardbacks/cardback_mountains.png";
				makeFullDeck();
			}

		});

		// reptiles chosen
		reptiles.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {

			/**
			 * Handler for if the reptiles card back is clicked. Starts a new
			 * round with the reptiles deck and sets the cardBackPath to the
			 * reptile images. Then calls a private method to create a full
			 * deck of reptiles cards.
			 * @param event MouseEvent for if reptiles card is clicked
			 */
			@Override
			public void handle(MouseEvent event) {
				curRound = new Round("reptiles", 8);
				cardBackPath = "file:src/images/cardbacks/cardback_reptiles.png";
				makeFullDeck();
			}

		});

		// Set background image
		this.setStyle("-fx-background-image: url('file:src/images/desertbackground.jpg')");

	}

	private void makeFullDeck() {
		
		this.setAlignment(Pos.CENTER);

		// remove deck choices
		this.getChildren().remove(cacti);
		this.getChildren().remove(cities);
		this.getChildren().remove(mammals);
		this.getChildren().remove(mountains);
		this.getChildren().remove(reptiles);
		
		// add label
		this.add(stats, 4, 0);
		
		this.add(new ImageView(new Image(cardBackPath, 125, 175, false, false)), 0, 1);
		this.add(new ImageView(new Image(cardBackPath, 125, 175, false, false)), 1, 1);
		this.add(new ImageView(new Image(cardBackPath, 125, 175, false, false)), 2, 1);
		this.add(new ImageView(new Image(cardBackPath, 125, 175, false, false)), 3, 1);

		this.add(new ImageView(new Image(cardBackPath, 125, 175, false, false)), 0, 2);
		this.add(new ImageView(new Image(cardBackPath, 125, 175, false, false)), 1, 2);
		this.add(new ImageView(new Image(cardBackPath, 125, 175, false, false)), 2, 2);
		this.add(new ImageView(new Image(cardBackPath, 125, 175, false, false)), 3, 2);

		this.add(new ImageView(new Image(cardBackPath, 125, 175, false, false)), 0, 3);
		this.add(new ImageView(new Image(cardBackPath, 125, 175, false, false)), 1, 3);
		this.add(new ImageView(new Image(cardBackPath, 125, 175, false, false)), 2, 3);
		this.add(new ImageView(new Image(cardBackPath, 125, 175, false, false)), 3, 3);

		this.add(new ImageView(new Image(cardBackPath, 125, 175, false, false)), 0, 4);
		this.add(new ImageView(new Image(cardBackPath, 125, 175, false, false)), 1, 4);
		this.add(new ImageView(new Image(cardBackPath, 125, 175, false, false)), 2, 4);
		this.add(new ImageView(new Image(cardBackPath, 125, 175, false, false)), 3, 4);
		

		Image cardOneBack = new Image(curRound.getCard(0).getFileName(), 125, 175, false, false);
		Image cardTwoBack = new Image(curRound.getCard(1).getFileName(), 125, 175, false, false);
		Image cardThreeBack = new Image(curRound.getCard(2).getFileName(), 125, 175, false, false);
		Image cardFourBack = new Image(curRound.getCard(3).getFileName(), 125, 175, false, false);
		Image cardFiveBack = new Image(curRound.getCard(4).getFileName(), 125, 175, false, false);
		Image cardSixBack = new Image(curRound.getCard(5).getFileName(), 125, 175, false, false);
		Image cardSevenBack = new Image(curRound.getCard(6).getFileName(), 125, 175, false, false);
		Image cardEightBack = new Image(curRound.getCard(7).getFileName(), 125, 175, false, false);
		Image cardNineBack = new Image(curRound.getCard(8).getFileName(), 125, 175, false, false);
		Image cardTenBack = new Image(curRound.getCard(9).getFileName(), 125, 175, false, false);
		Image cardElevenBack = new Image(curRound.getCard(10).getFileName(), 125, 175, false, false);
		Image cardTwelveBack = new Image(curRound.getCard(11).getFileName(), 125, 175, false, false);
		Image cardThirteenBack = new Image(curRound.getCard(12).getFileName(), 125, 175, false, false);
		Image cardFourteenBack = new Image(curRound.getCard(13).getFileName(), 125, 175, false, false);
		Image cardFifteenBack = new Image(curRound.getCard(14).getFileName(), 125, 175, false, false);
		Image cardSixteenBack = new Image(curRound.getCard(15).getFileName(), 125, 175, false, false);

		for (int i = 0; i < 16; i += 1)
			textLabels[i] = getCardTextLabel(curRound.getCard(i).getName(), 125, 175);
		

	}

	private void setMouseHandler() {
		this.setOnMouseClicked(event -> {

			if (firstGuess && gameStarted) {
				firstGuess = false;
				clickedCardOne = getClickedCard(event);
				rowOne = clickRow;
				colOne = clickCol;
				guessPos1 = guessPos;
				if (clickedCardOne != null && guessPos1 >= 0) {
					this.add(new ImageView(new Image(clickedCardOne.getFileName(), 125, 175, false, false)), clickCol,
							clickRow);
					this.add(textLabels[(clickRow - 1) * 4 + clickCol], clickCol, clickRow);
				} else {
					firstGuess = true;
				}
			} else {
				if (gameStarted) {
					if (clickedCardTwo != null && guessPos1 != guessPos2) {
						firstGuess = true;
						try {
							Thread.sleep(1250);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						checkCards();
					}
				} else {
					gameStarted = true;
				}
			}

		});

		this.setOnMousePressed(event -> {

			if (!firstGuess) {
				clickedCardTwo = getClickedCard(event);
				rowTwo = clickRow;
				colTwo = clickCol;
				guessPos2 = guessPos;

				if (clickedCardTwo != null && clickedCardTwo != clickedCardOne && guessPos2 >= 0) {
					this.add(new ImageView(new Image(clickedCardTwo.getFileName(), 125, 175, false, false)), clickCol,
							clickRow);
					this.add(textLabels[(clickRow - 1) * 4 + clickCol], clickCol, clickRow);
				}
			}
		});

	}
	
	private void changeCardOne() {
		this.add(new ImageView(new Image(clickedCardOne.getFileName(), 125, 175, false, false)), colOne,
				rowOne);
		this.add(textLabels[(rowOne - 1) * 4 + colOne], colOne, rowOne);
	}
	
	private void changeCardTwo() {
		this.add(new ImageView(new Image(clickedCardTwo.getFileName(), 125, 175, false, false)), colTwo,
				rowTwo);
		this.add(textLabels[(rowTwo - 1) * 4 + colTwo], colTwo, rowTwo);
		
	}

	private Card getClickedCard(MouseEvent event) {
		Card clickedCard = null;
		double clickX = event.getX();
		double clickY = event.getY();

		// row one
		if (clickY >= 34 && clickY <= 202) {
			clickRow = 1;
			// cardOne
			if (clickX >= 239 && clickX <= 356) {
				clickCol = 0;
				clickedCard = curRound.getCard(0);
				guessPos = 0;
				// cardTwo
			} else if (clickX >= 375 && clickX <= 491) {
				clickCol = 1;
				clickedCard = curRound.getCard(1);
				guessPos = 1;
				// cardThree
			} else if (clickX >= 508 && clickX <= 627) {
				clickCol = 2;
				clickedCard = curRound.getCard(2);
				guessPos = 2;
				// cardFour
			} else if (clickX >= 643 && clickX <= 763) {
				clickCol = 3;
				clickedCard = curRound.getCard(3);
				guessPos = 3;
			}
			// row two
		} else if (clickY >= 218 && clickY <= 385) {
			clickRow = 2;
			// cardFive
			if (clickX >= 239 && clickX <= 356) {
				clickCol = 0;
				clickedCard = curRound.getCard(4);
				guessPos = 4;
				// cardSix
			} else if (clickX >= 374 && clickX <= 491) {
				clickCol = 1;
				clickedCard = curRound.getCard(5);
				guessPos = 5;
				// cardSeven
			} else if (clickX >= 508 && clickX <= 627) {
				clickCol = 2;
				clickedCard = curRound.getCard(6);
				guessPos = 6;
				// cardEight
			} else if (clickX >= 643 && clickX <= 763) {
				clickCol = 3;
				clickedCard = curRound.getCard(7);
				guessPos = 7;
			}
			// row three
		} else if (clickY >= 403 && clickY <= 572) {
			clickRow = 3;
			// cardNine
			if (clickX >= 239 && clickX <= 356) {
				clickCol = 0;
				clickedCard = curRound.getCard(8);
				guessPos = 8;
				// cardTen
			} else if (clickX >= 375 && clickX <= 491) {
				clickCol = 1;
				clickedCard = curRound.getCard(9);
				guessPos = 9;
				// cardEleven
			} else if (clickX >= 508 && clickX <= 627) {
				clickCol = 2;
				clickedCard = curRound.getCard(10);
				guessPos = 10;
				// cardTwelve
			} else if (clickX >= 643 && clickX <= 763) {
				clickCol = 3;
				clickedCard = curRound.getCard(11);
				guessPos = 11;
			}

			// row four
		} else if (clickY >= 588 && clickY <= 755) {
			clickRow = 4;
			// cardThirteen
			if (clickX >= 239 && clickX <= 356) {
				clickCol = 0;
				clickedCard = curRound.getCard(12);
				guessPos = 12;
				// cardFourteen
			} else if (clickX >= 375 && clickX <= 491) {
				clickCol = 1;
				clickedCard = curRound.getCard(13);
				guessPos = 13;
				// cardFifteen
			} else if (clickX >= 508 && clickX <= 627) {
				clickCol = 2;
				clickedCard = curRound.getCard(14);
				guessPos = 14;
				// cardSixteen
			} else if (clickX >= 643 && clickX <= 763) {
				clickCol = 3;
				clickedCard = curRound.getCard(15);
				guessPos = 15;
			}
		} else {
			guessPos = -1;
			return null;
		}

		return clickedCard;
	}

	private void checkCards() {
		if (curRound.isActive()) {
			guessCount += 1;

			if (!clickedCardOne.equals(nullCard) && !clickedCardTwo.equals(nullCard)) {
				curRound.makeGuess(guessPos1, guessPos2);
				// see if cards match
				if (clickedCardOne.getName().equals(clickedCardTwo.getName())) {
					Rectangle rectOne = new Rectangle();
					rectOne.setWidth(125);
					rectOne.setHeight(175);
					rectOne.setFill(Color.WHITE);

					Rectangle rectTwo = new Rectangle();
					rectTwo.setWidth(125);
					rectTwo.setHeight(175);
					rectTwo.setFill(Color.WHITE);

					this.add(rectOne, colOne, rowOne);
					this.add(rectTwo, colTwo, rowTwo);
					clickedCardOne = nullCard;
					clickedCardTwo = nullCard;
					this.getChildren().remove(textLabels[(rowOne - 1) * 4 + colOne]);
					this.getChildren().remove(textLabels[(rowTwo - 1) * 4 + colTwo]);
					scoreCount += 1;

				} else {
					this.add(new ImageView(new Image(cardBackPath, 125, 175, false, false)), colOne, rowOne);
					this.add(new ImageView(new Image(cardBackPath, 125, 175, false, false)), colTwo, rowTwo);
					clickedCardOne = nullCard;
					clickedCardTwo = nullCard;
					this.getChildren().remove(textLabels[(rowOne - 1) * 4 + colOne]);
					this.getChildren().remove(textLabels[(rowTwo - 1) * 4 + colTwo]);
				}
			}
		}

		if (!curRound.isActive()) {
			String score = curRound.getScore().toString();
			System.out.println("Game finished");
			scoreMsg = new Label("Your score: " + score);
			this.add(scoreMsg, 0, 4);
		}
		
		stats.setText("guesses: " + guessCount + "\nscore: " + scoreCount);
	}

	/**
	 * Creates and returns a Label with outlined text of the card name
	 * 
	 * @param cardName   is the name of the card
	 * @param cardWidth  is the width of the card in pixels
	 * @param cardHeight is the height of the card in pixels
	 * @return a label with outlined text of the card's name.
	 */
	private Label getCardTextLabel(String cardName, double cardWidth, double cardHeight) {
		// Dimensions of card image files
		final double CARD_IMAGE_WIDTH = 202;
		final double CARD_IMAGE_HEIGHT = 275;

		// Dimensions cards will be drawn at (if you change this you'll need to change
		// the font size in TextOutline.css.)
		final double drawnCardWidth = cardWidth;
		final double drawnCardHeight = cardHeight;

		// Scale of card vs. image (so we can scale drawing coordinates below)
		double xScale = drawnCardWidth / CARD_IMAGE_WIDTH;
		double yScale = drawnCardHeight / CARD_IMAGE_HEIGHT;

		// Text
		Label cardText = new Label(cardName);
		cardText.setTextAlignment(TextAlignment.CENTER);
		cardText.setAlignment(Pos.BOTTOM_CENTER);
		cardText.setLineSpacing(-9 * yScale);

		// Align text at 15% from bottom of card
		GridPane.setHalignment(cardText, HPos.CENTER);
		GridPane.setValignment(cardText, VPos.BOTTOM);
		cardText.setPadding(new Insets(0, 0, drawnCardHeight * 0.15 * yScale, 0));
		cardText.setWrapText(true);
		cardText.setPrefWidth(145 * xScale);

		return cardText;
	}
}
