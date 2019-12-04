package fabienguidetti.adventofcode2019.day04;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class RulesTest {
	@Test
	public void meetsCriteriaPuzzle1() {
		assertTrue(Rules.meetsCriteriaPuzzle1(111111));
		assertFalse(Rules.meetsCriteriaPuzzle1(223450));
		assertFalse(Rules.meetsCriteriaPuzzle1(123789));
	}
}
