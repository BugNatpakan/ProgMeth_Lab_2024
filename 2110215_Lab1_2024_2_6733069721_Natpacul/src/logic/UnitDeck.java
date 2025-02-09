package logic;

import java.util.ArrayList;

import org.hamcrest.text.IsBlankString;

public class UnitDeck {
	private ArrayList<CardCounter> cardsInDeck = new ArrayList<>();
	private String deckName;

	public UnitDeck(String deckName) {
		setDeckName(deckName);
	}

	public void setCardsInDeck(ArrayList<CardCounter> cardsInDeck) {
		this.cardsInDeck = cardsInDeck;
	}

	public ArrayList<CardCounter> getCardsInDeck() {
		return cardsInDeck;
	}

	public String getDeckName() {
		return deckName;
	}

	public void setDeckName(String deckName) {
		if (deckName.isBlank()) {
			deckName = "Untitled Deck";
		}
		this.deckName = deckName;
	}

	public void addCard(UnitCard newCard, int count) {
		if (count <= 0) {
			return;
		}

		boolean foundCard = false;

		for (int i = 0; i < cardsInDeck.size(); i++) {

			CardCounter currCard = cardsInDeck.get(i);

			if (currCard.getCard() == newCard) {

				currCard.setCount(currCard.getCount() + count);

				foundCard = true;
				break;
			}
		}

		if (!foundCard) {
			CardCounter cardToAdd = new CardCounter(newCard, count);
			cardsInDeck.add(cardToAdd);
		}
	}

	public void removeCard(UnitCard toRemove, int count) {
		if (count <= 0) {
			return;
		}
		for (int i = 0; i < cardsInDeck.size(); i++) {
			CardCounter currCard = cardsInDeck.get(i);

			if (currCard.getCard() == toRemove) {

				int currCount = currCard.getCount();

				if (currCount > count) {
					currCard.setCount(currCount - count);
				} else {
					cardsInDeck.remove(i);
				}

				break;
			}
		}
	}

	public int cardCount() {
		int total = 0;
		for (CardCounter currCard : cardsInDeck) {
			total += currCard.getCount();
		}
		return total;
	}

	public boolean existsInDeck(UnitCard card) {
		for (CardCounter currCard : cardsInDeck) {
			if (currCard.getCard() == card) {
				return true;
			}
		}

		return false;
	}

	public boolean equals(UnitDeck other) {
		if (other.deckName == this.deckName) {
			return true;
		}

		return false;
	}

}
