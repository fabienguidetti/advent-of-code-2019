package fabienguidetti.adventofcode2019.day01;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import fabienguidetti.adventofcode2019.day01.Module;

public class ModuleTest {
	@Test
	public void testFuelRequired() {
		assertEquals(2, Module.fuelRequired(12));
		assertEquals(2, Module.fuelRequired(14));
		assertEquals(654, Module.fuelRequired(1969));
		assertEquals(33583, Module.fuelRequired(100756));
	}
}
