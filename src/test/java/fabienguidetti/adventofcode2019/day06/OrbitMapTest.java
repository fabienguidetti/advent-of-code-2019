package fabienguidetti.adventofcode2019.day06;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class OrbitMapTest {
	@Test
	public void testChecksum() {
		OrbitMap orbits = new OrbitMap();
		orbits.addOrbit("COM", "B");
		orbits.addOrbit("B", "C");
		orbits.addOrbit("C", "D");
		orbits.addOrbit("D", "E");
		orbits.addOrbit("E", "F");
		orbits.addOrbit("B", "G");
		orbits.addOrbit("G", "H");
		orbits.addOrbit("D", "I");
		orbits.addOrbit("E", "J");
		orbits.addOrbit("J", "K");
		orbits.addOrbit("K", "L");

		assertEquals(42, orbits.checksum());
	}
}
