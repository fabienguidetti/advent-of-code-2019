package fabienguidetti.adventofcode2019.day22;

import java.util.Arrays;

class Deck {
	private int[] cards;

	Deck(int size) {
		cards = new int[size];
		for (int i = 0; i < size; i++) {
			cards[i] = i;
		}
	}

	int size() {
		return cards.length;
	}

	int card(int cardIndex) {
		return cards[cardIndex];
	}

	void setCard(int cardIndex, int value) {
		cards[cardIndex] = value;
	}

	int positionOf(int cardValue) {
		for (int i = 0; i < size(); i++) {
			if (card(i) == cardValue) {
				return i;
			}
		}
		return -1; // not found
	}

	Deck shuffle(String shufflingTechniqueText) {
		return ShufflingTechnique.fromString(shufflingTechniqueText).applyOn(this);
	}

	@Override
	public String toString() {
		return Arrays.toString(cards).replaceAll(",", "");
	}
}
