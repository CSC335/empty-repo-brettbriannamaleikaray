package controller_view;

import java.util.ArrayList;

import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.text.TextAlignment;
import model.Card;
import model.Guess;
import model.Mode;
import model.Round;

/**
 * Starts a new Round of the Memory Game. It first shows 5 card backs that
 * represent a different theme. Once a card back is chosen a new deck is shown
 * and the game begins. As the game is played the number of guesses and a score
 * is kept. Once all the card pairs have been found the round ends.
 */
public class Match4RoundPane extends GridPane {

	private Card nullCard = new Card("null", "null");
	private Label scoreMsg;
	private Label winMsg;
	private Card clickedCardOne = nullCard;
	private Card clickedCardTwo = nullCard;
	private Card clickedCardThree = nullCard;
	private Card clickedCardFour = nullCard;
	double firstX;
	double firstY;
	double clickX;
	double clickY;
	private int clickRow;
	private int clickCol;
	private int rowOne;
	private int rowTwo;
	private int rowThree;
	private int rowFour;
	private int colOne;
	private int colTwo;
	private int colThree;
	private int colFour;
	private int guessPos;
	private int guessPos1;
	private int guessPos2;
	private int guessPos3;
	private int guessPos4;
	private int numOfCardsFlipped = 0;
	private Label[] textLabels = new Label[16];
	private ArrayList<ImageView> cardImages;
	private ImageView cacti;
	private ImageView cities;
	private ImageView mammals;
	private ImageView mountains;
	private ImageView reptiles;
	private boolean gameStarted = false;
	private Label stats = new Label("guesses: 0\n score: 0");
	private int guessCount = 0;
	private int scoreCount = 0;
	private int cardOneIndex = -1;
	private int cardTwoIndex = -1;
	private int cardThreeIndex = -1;
	private int cardFourIndex = -1;
	private Button returnToTitle = new Button("Return to Title Screen");
	private Button leaderBoard = new Button("Show LeaderBoard");

//	private CardSet deck;
	private String cardBackPath;
	private Round curRound;
	private MemoryGameGUI memoryGame;
	private Mode mode;

	/**
	 * Constructs a new RoundPane
	 * 
	 * @param memoryGame The MemoryGameGUI object that controls the GUI
	 */
	public Match4RoundPane(MemoryGameGUI memoryGame, Mode mode) {
		this.memoryGame = memoryGame;
		this.mode = mode;
		layoutGUI();
		registerButtons();
		setMouseHandler();
		cardImages = new ArrayList<ImageView>();

		// Load CSS for text labels
		this.getStylesheets().addAll(getClass().getResource("TextOutline.css").toExternalForm());
	}

	private void layoutGUI() {

		this.setHgap(10);
		this.setVgap(10);
		this.setAlignment(Pos.CENTER);
		returnToTitle.setStyle("-fx-background-color: papayawhip; -fx-text-fill: black;");
		this.add(returnToTitle, 4, 1);

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
			 * Handler for if the cacti card back is clicked. Starts a new round with the
			 * cacti deck and sets the cardBackPath to the cacti images. Then calls a
			 * private method to create a full deck of cacti cards.
			 * 
			 * @param event MouseEvent for if cacti card is clicked
			 */
			@Override
			public void handle(MouseEvent event) {
				curRound = new Round(mode, "cacti", 4);
				cardBackPath = "file:src/images/cardbacks/cardback_cacti.png";
				makeFullDeck();
			}

		});

		// cities chosen
		cities.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {

			/**
			 * Handler for if the cities card back is clicked. Starts a new round with the
			 * cities deck and sets the cardBackPath to the city images. Then calls a
			 * private method to create a full deck of city cards.
			 * 
			 * @param event MouseEvent for if cities card is clicked
			 */
			@Override
			public void handle(MouseEvent event) {
				curRound = new Round(mode, "cities", 4);
				cardBackPath = "file:src/images/cardbacks/cardback_cities.png";
				makeFullDeck();
			}

		});

		// mammals chosen
		mammals.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {

			/**
			 * Handler for if the mammals card back is clicked. Starts a new round with the
			 * mammals deck and sets the cardBackPath to the mammal images. Then calls a
			 * private method to create a full deck of mammals cards.
			 * 
			 * @param event MouseEvent for if mammals card is clicked
			 */
			@Override
			public void handle(MouseEvent event) {
				curRound = new Round(mode, "mammals", 4);
				cardBackPath = "file:src/images/cardbacks/cardback_mammals.png";
				makeFullDeck();
			}

		});

		// mountains chosen
		mountains.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {

			/**
			 * Handler for if the mountains card back is clicked. Starts a new round with
			 * the mountains deck and sets the cardBackPath to the mountain images. Then
			 * calls a private method to create a full deck of mountains cards.
			 * 
			 * @param event MouseEvent for if mountanis card is clicked
			 */
			@Override
			public void handle(MouseEvent event) {
				curRound = new Round(mode, "mountains", 4);
				cardBackPath = "file:src/images/cardbacks/cardback_mountains.png";
				makeFullDeck();
			}

		});

		// reptiles chosen
		reptiles.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {

			/**
			 * Handler for if the reptiles card back is clicked. Starts a new round with the
			 * reptiles deck and sets the cardBackPath to the reptile images. Then calls a
			 * private method to create a full deck of reptiles cards.
			 * 
			 * @param event MouseEvent for if reptiles card is clicked
			 */
			@Override
			public void handle(MouseEvent event) {
				curRound = new Round(mode, "reptiles", 4);
				cardBackPath = "file:src/images/cardbacks/cardback_reptiles.png";
				makeFullDeck();
			}

		});

		// Set background image
		this.setStyle("-fx-background-image: url('file:src/images/desertbackground.jpg')");

	}

	private void registerButtons() {
		returnToTitle.setOnAction(event -> {
			memoryGame.showTitle();
		});
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

		// add card text label
		for (int i = 0; i < 16; i += 1) {
			textLabels[i] = getCardTextLabel(curRound.getCard(i).getName(), 125, 175);
			cardImages.add(new ImageView(new Image(cardBackPath, 125, 175, false, false)));

			// add front-of-card image to board
			this.add(cardImages.get(cardImages.size() - 1), i % 4, i / 4);
		}
	}

	private void setMouseHandler() {
		this.setOnMousePressed(event -> {
			if (numOfCardsFlipped == 0 && gameStarted) {
				clickedCardOne = getClickedCard(event);
				rowOne = clickRow;
				colOne = clickCol;
				cardOneIndex = rowOne * 4 + colOne;
				guessPos1 = guessPos;
				if (clickedCardOne != null && guessPos1 >= 0) {
					flipCardOne();
				}
			} else if (numOfCardsFlipped == 1 && gameStarted) {
				clickedCardTwo = getClickedCard(event);
				rowTwo = clickRow;
				colTwo = clickCol;
				cardTwoIndex = rowTwo * 4 + colTwo;
				guessPos2 = guessPos;
				if (clickedCardTwo != null && guessPos2 >= 0 && guessPos2 != guessPos1) {
					flipCardTwo();
				}
			} else if (numOfCardsFlipped == 2 && gameStarted) {
				clickedCardThree = getClickedCard(event);
				rowThree = clickRow;
				colThree = clickCol;
				cardThreeIndex = rowThree * 4 + colThree;
				guessPos3 = guessPos;
				if (clickedCardThree != null && guessPos3 >= 0 && guessPos3 != guessPos1 && guessPos3 != guessPos2) {
					flipCardThree();
				}
			} else if (numOfCardsFlipped == 3 && gameStarted) {
				clickedCardFour = getClickedCard(event);
				rowFour = clickRow;
				colFour = clickCol;
				cardFourIndex = rowFour * 4 + colFour;
				guessPos4 = guessPos;
				if (clickedCardFour != null && guessPos4 >= 0 && guessPos4 != guessPos1 && guessPos4 != guessPos2
						&& guessPos4 != guessPos3) {
					flipCardFour();
				}
				if (clickedCardFour != null && guessPos4 >= 0 && guessPos4 != guessPos1 && guessPos4 != guessPos2
						&& guessPos4 != guessPos3) {
					try {
						Thread.sleep(1250);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					checkCards();
				}
			} else if (!gameStarted) {
				gameStarted = true;
			}
		});
	}

	private void flipCardOne() {
		// (Card One) Changes a card's image to the image on its other side
		if (clickedCardOne.isFlipped() == false) {
			// Change to front image
			cardImages.get(cardOneIndex)
					.setImage(new Image(curRound.getCard(cardOneIndex).getFileName(), 125, 175, false, false));
			// Add text label
			this.add(textLabels[cardOneIndex], colOne, rowOne);
			numOfCardsFlipped += 1;
		} else if (clickedCardOne.isFlipped() == true) {
			// Change to back image
			cardImages.get(cardOneIndex).setImage(new Image(cardBackPath, 125, 175, false, false));
			// Remove text label
			this.getChildren().remove(textLabels[cardOneIndex]);
			numOfCardsFlipped -= 1;
		}
		// Update flip status
		clickedCardOne.flipCard();
	}

	private void flipCardTwo() {
		// (Card Two) Changes a card's image to the image on its other side
		if (clickedCardTwo.isFlipped() == false) {
			// Change to front image
			cardImages.get(cardTwoIndex)
					.setImage(new Image(curRound.getCard(cardTwoIndex).getFileName(), 125, 175, false, false));
			// Add text label
			this.add(textLabels[cardTwoIndex], colTwo, rowTwo);
			numOfCardsFlipped += 1;
		} else if (clickedCardTwo.isFlipped() == true) {
			// Change to back image
			cardImages.get(cardTwoIndex).setImage(new Image(cardBackPath, 125, 175, false, false));
			// Remove text label
			this.getChildren().remove(textLabels[cardTwoIndex]);
			numOfCardsFlipped -= 1;
		}
		// Update flip status
		clickedCardTwo.flipCard();
	}

	private void flipCardThree() {
		// (Card Three) Changes a card's image to the image on its other side
		if (clickedCardThree.isFlipped() == false) {
			// Change to front image
			cardImages.get(cardThreeIndex)
					.setImage(new Image(curRound.getCard(cardThreeIndex).getFileName(), 125, 175, false, false));
			// Add text label
			this.add(textLabels[cardThreeIndex], colThree, rowThree);
			numOfCardsFlipped += 1;
		} else if (clickedCardThree.isFlipped() == true) {
			// Change to back image
			cardImages.get(cardThreeIndex).setImage(new Image(cardBackPath, 125, 175, false, false));
			// Remove text label
			this.getChildren().remove(textLabels[cardThreeIndex]);
			numOfCardsFlipped -= 1;
		}
		// Update flip status
		clickedCardThree.flipCard();
	}

	private void flipCardFour() {
		// (Card Four) Changes a card's image to the image on its other side
		if (clickedCardFour.isFlipped() == false) {
			// Change to front image
			System.out.println("flip");
			cardImages.get(cardFourIndex)
					.setImage(new Image(curRound.getCard(cardFourIndex).getFileName(), 125, 175, false, false));
			// Add text label
			this.add(textLabels[cardFourIndex], colFour, rowFour);
			numOfCardsFlipped += 1;
		} else if (clickedCardFour.isFlipped() == true) {
			// Change to back image
			cardImages.get(cardFourIndex).setImage(new Image(cardBackPath, 125, 175, false, false));
			// Remove text label
			this.getChildren().remove(textLabels[cardFourIndex]);
			numOfCardsFlipped -= 1;
		}
		// Update flip status
		clickedCardFour.flipCard();
	}

	private Card getClickedCard(MouseEvent event) {
		Card clickedCard = null;
		double clickX = event.getX();
		double clickY = event.getY();

		final int topLeftX = 198; // x of where top left of card board is
		final int topLeftY = 159; // y of where top left of card board is
		final int cardGap = 10; // gap between cards, same horizontal or vertical
		final int cardWidth = 125;
		final int cardHeight = 175;
		final int rowWidth = 4 * (cardWidth + cardGap);

		// Figures out which card you clicked based on x and y coordinates
		// If card/row/gap size change just edit the variables above
		for (int i = 0; i < 16; i += 1) {
			if (curRound.getCard(i).isDestroyed() == false) {
				if (clickX >= (topLeftX + (i * (cardWidth + cardGap))) - (((i / 4) * rowWidth))
						&& clickX <= (topLeftX + (i * (cardWidth + cardGap))) - (((i / 4) * rowWidth)) + cardWidth
						&& clickY >= topLeftY + ((i / 4) * (cardHeight + cardGap))
						&& clickY <= topLeftY + ((i / 4) * (cardHeight + cardGap) + cardHeight)) {
					clickCol = i % 4;
					clickRow = i / 4;
					guessPos = i;
					clickedCard = curRound.getCard(i);
				}
			}
		}

		return clickedCard;
	}

	private void checkCards() {
		if (curRound.isActive()) {
			guessCount += 1;

			if (!clickedCardOne.equals(nullCard) && !clickedCardTwo.equals(nullCard)
					&& !clickedCardThree.equals(nullCard) && !clickedCardFour.equals(nullCard)) {
				Guess guess = new Guess(guessPos1, guessPos2, guessPos3, guessPos4);
				curRound.makeGuess(guess);
				// see if cards match
				if (clickedCardOne.getName().equals(clickedCardTwo.getName())
						&& clickedCardTwo.getName().equals(clickedCardThree.getName())
						&& clickedCardThree.getName().equals(clickedCardFour.getName())) {
					// Match confirmed
					// Set card's destroyed flag so it's unclickable
					curRound.getCard(cardOneIndex).destroyCard();
					curRound.getCard(cardTwoIndex).destroyCard();
					curRound.getCard(cardThreeIndex).destroyCard();
					curRound.getCard(cardFourIndex).destroyCard();
					numOfCardsFlipped = 0;

					// Set the card's image to be a transparent placeholder image
					cardImages.get(cardOneIndex)
							.setImage(new Image("file:src/images/emptycard.png", 125, 175, false, false));
					cardImages.get(cardTwoIndex)
							.setImage(new Image("file:src/images/emptycard.png", 125, 175, false, false));
					cardImages.get(cardThreeIndex)
							.setImage(new Image("file:src/images/emptycard.png", 125, 175, false, false));
					cardImages.get(cardFourIndex)
							.setImage(new Image("file:src/images/emptycard.png", 125, 175, false, false));

					// Remove card text
					this.getChildren().remove(textLabels[cardOneIndex]);
					this.getChildren().remove(textLabels[cardTwoIndex]);
					this.getChildren().remove(textLabels[cardThreeIndex]);
					this.getChildren().remove(textLabels[cardFourIndex]);

					// Increase score
					scoreCount += 1;

				} else {
					// No match
					// Flip cards back over, reset click variables, remove text labels
					flipCardOne();
					flipCardTwo();
					flipCardThree();
					flipCardFour();
					numOfCardsFlipped = 0;
					clickedCardOne = nullCard;
					clickedCardTwo = nullCard;
					clickedCardThree = nullCard;
					clickedCardFour = nullCard;
					this.getChildren().remove(textLabels[cardOneIndex]);
					this.getChildren().remove(textLabels[cardTwoIndex]);
					this.getChildren().remove(textLabels[cardThreeIndex]);
					this.getChildren().remove(textLabels[cardFourIndex]);
				}
			}
		}

		if (!curRound.isActive()) {
			this.memoryGame.getLoginPane().getCurrentAccount().addRound(curRound);
			// maybe remove this code now that there's a score counter
			// System.out.println("Game finished");
			// String score = curRound.getScore().toString();
			// scoreMsg = new Label("Your score: " + score);
			// this.add(scoreMsg, 0, 4);
			winMsg = new Label("You Win!");
			this.add(winMsg, 2, 1);
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