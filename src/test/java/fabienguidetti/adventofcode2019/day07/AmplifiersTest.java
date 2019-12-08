package fabienguidetti.adventofcode2019.day07;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AmplifiersTest {
	@Test
	public void testProgram1() {
		Amplifiers amplifiers1 = new Amplifiers("3,15,3,16,1002,16,10,16,1,16,15,15,4,15,99,0,0");
		assertEquals(43210, amplifiers1.maxSignal());
	}

	@Test
	public void testProgram2() {
		Amplifiers amplifiers2 = new Amplifiers("3,23,3,24,1002,24,10,24,1002,23,-1,23," +
				"101,5,23,23,1,24,23,23,4,23,99,0,0");
		assertEquals(54321, amplifiers2.maxSignal());
	}

	@Test
	public void testProgram3() {
		Amplifiers amplifiers3 = new Amplifiers("3,31,3,32,1002,32,10,32,1001,31,-2,31,1007,31,0,33," +
				"1002,33,7,33,1,33,31,31,1,32,31,31,4,31,99,0,0,0");
		assertEquals(65210, amplifiers3.maxSignal());
	}
}
