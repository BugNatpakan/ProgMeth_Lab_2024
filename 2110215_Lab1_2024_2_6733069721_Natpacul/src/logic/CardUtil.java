package logic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class CardUtil {

	public static boolean isExistsInList(UnitCard card, ArrayList<UnitCard> list) {

		// TODO: Fill Code

		for (UnitCard c : list) {
			if (card.equals(c)) {
				return true;
			}
		}

		return false;
	}

	public static boolean isExistsInList(UnitDeck deck, ArrayList<UnitDeck> list) {

		// TODO: Fill Code

		for (UnitDeck d : list) {
			if (deck.equals(d)) {
				return true;
			}
		}

		return false;

	}

	public static boolean cardExistsInDeckList(ArrayList<UnitDeck> deckList, UnitCard cardToTest) {

		// TODO: Fill Code

		for (UnitDeck d : deckList) {
			ArrayList<CardCounter> cardsInDeck = d.getCardsInDeck();
			for (CardCounter cc : cardsInDeck) {
				if (cardToTest.equals(cc.getCard())) {
					return true;
				}
			}
		}

		return false;
	}

	public static ArrayList<UnitCard> getCardsFromFile(String filename) throws FileNotFoundException {
		ArrayList<UnitCard> cardsFromFile = new ArrayList<UnitCard>();
		File fileToRead = new File(filename);
		try (Scanner reader = new Scanner(fileToRead)) {

			while (reader.hasNextLine()) {
				String data = reader.nextLine().trim();

				String[] newCardData = data.split(",");

				if(newCardData.length != 5) {
					System.out.println("File contains string with incorrect format!");
					return null;
				}
				
				String name = newCardData[0];
				int bloodCost = Integer.parseInt(newCardData[1]);
				int power = Integer.parseInt(newCardData[2]);
				int health = Integer.parseInt(newCardData[3]);
				String flavorText = newCardData[4];

				UnitCard newCard = new UnitCard(name, bloodCost, power, health, flavorText);

				cardsFromFile.add(newCard);
			}
		} catch (Exception e) {
			System.out.println("Cannot find file!");
			System.out.println("File error! No new card added.");
		}

		return cardsFromFile;
	}

	public static void printCardList(ArrayList<UnitCard> cardList, boolean verbose) {

		for (int i = 0; i < cardList.size(); i++) {
			System.out.println(i + ") " + cardList.get(i));
			if (verbose) {
				System.out.println("Blood Cost: " + cardList.get(i).getBloodCost());
				System.out.println(cardList.get(i).getFlavorText());
				if (i < cardList.size() - 1)
					System.out.println("-----");
			}
		}
	}

	public static void printDeck(UnitDeck ud) {

		if (ud.getCardsInDeck().size() == 0) {
			System.out.println("EMPTY DECK");
		} else {
			for (CardCounter cc : ud.getCardsInDeck()) {
				System.out.println(cc);
			}
		}

		System.out.println("Total Cards: " + ud.cardCount());
	}

	public static void printDeckList(ArrayList<UnitDeck> deckList) {

		for (int i = 0; i < deckList.size(); i++) {
			System.out.println(i + ") " + deckList.get(i).getDeckName());
			printDeck(deckList.get(i));
			if (i < deckList.size() - 1)
				System.out.println("-----");
		}
	}
}
