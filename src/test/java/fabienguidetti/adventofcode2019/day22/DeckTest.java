package fabienguidetti.adventofcode2019.day22;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class DeckTest {

	@Test
	public void testExample1() {
		Deck deck = new Deck(10);
		deck = deck.shuffle("deal with increment 7");
		deck = deck.shuffle("deal into new stack");
		deck = deck.shuffle("deal into new stack");
		assertEquals("[0 3 6 9 2 5 8 1 4 7]", deck.toString());
	}

	@Test
	public void testExample2() {
		Deck deck = new Deck(10);
		deck = deck.shuffle("cut 6");
		deck = deck.shuffle("deal with increment 7");
		deck = deck.shuffle("deal into new stack");
		assertEquals("[3 0 7 4 1 8 5 2 9 6]", deck.toString());
	}

	@Test
	public void testExample3() {
		Deck deck = new Deck(10);
		deck = deck.shuffle("deal with increment 7");
		deck = deck.shuffle("deal with increment 9");
		deck = deck.shuffle("cut -2");
		assertEquals("[6 3 0 7 4 1 8 5 2 9]", deck.toString());
	}

	@Test
	public void testExample4() {
		Deck deck = new Deck(10);
		deck = deck.shuffle("deal into new stack");
		deck = deck.shuffle("cut -2");
		deck = deck.shuffle("deal with increment 7");
		deck = deck.shuffle("cut 8");
		deck = deck.shuffle("cut -4");
		deck = deck.shuffle("deal with increment 7");
		deck = deck.shuffle("cut 3");
		deck = deck.shuffle("deal with increment 9");
		deck = deck.shuffle("deal with increment 3");
		deck = deck.shuffle("cut -1");
		assertEquals("[9 2 5 8 1 4 7 0 3 6]", deck.toString());
	}
}
