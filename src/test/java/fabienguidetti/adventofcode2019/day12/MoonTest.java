package fabienguidetti.adventofcode2019.day12;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class MoonTest {
	@Test
	public void testExample1() {
		Moon moon = Moon.of("<x=-4, y=3, z=15>");
		assertPosition(-4, 3, 15, moon);
		assertVelocity(0, 0, 0, moon);
	}

	static void assertPosition(int x, int y, int z, Moon moon) {
		assertEquals(x, moon.positionX());
		assertEquals(y, moon.positionY());
		assertEquals(z, moon.positionZ());
	}

	static void assertVelocity(int x, int y, int z, Moon moon) {
		assertEquals(x, moon.velocityX());
		assertEquals(y, moon.velocityY());
		assertEquals(z, moon.velocityZ());
	}
}
