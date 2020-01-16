package fabienguidetti.adventofcode2019.day22;

class DealIntoNewStack extends ShufflingTechnique {
	@Override
	Deck applyOn(Deck deck) {
		int size = deck.size();
		Deck newStack = new Deck(size);
		for (int i = 0; i < size; i++) {
			newStack.setCard(size - 1 - i, deck.card(i));
		}
		return newStack;
	}
}
