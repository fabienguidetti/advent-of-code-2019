package fabienguidetti.adventofcode2019.day22;

class DealWithIncrement extends ShufflingTechnique {
	int n;

	DealWithIncrement(int n) {
		this.n = n;
	}

	@Override
	Deck applyOn(Deck deck) {
		int size = deck.size();
		Deck spaceOnTable = new Deck(size);
		for (int i = 0; i < size; i++) {
			spaceOnTable.setCard((n * i) % size, deck.card(i));
		}
		return spaceOnTable;
	}
}
