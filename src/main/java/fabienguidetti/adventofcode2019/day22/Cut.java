package fabienguidetti.adventofcode2019.day22;

class Cut extends ShufflingTechnique {
	int n;

	Cut(int n) {
		this.n = n;
	}

	@Override
	Deck applyOn(Deck deck) {
		int size = deck.size();
		int cutParameter = (n >= 0 ? n : size + n);
		Deck cutCards = new Deck(size);
		for (int i = 0; i < cutParameter; i++) {
			cutCards.setCard(i + size - cutParameter, deck.card(i));
		}
		for (int i = cutParameter; i < size; i++) {
			cutCards.setCard(i - cutParameter, deck.card(i));
		}
		return cutCards;
	}
}
