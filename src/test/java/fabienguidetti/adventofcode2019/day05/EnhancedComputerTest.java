package fabienguidetti.adventofcode2019.day05;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import fabienguidetti.adventofcode2019.computer.Program;

public class EnhancedComputerTest {
	@Test
	public void testInputOutput() {
		Program program = new Program("3,0,4,0,99");
		program.setInput(1234);
		program.execute();
		assertEquals(1234, program.getOutput());
	}

	@Test
	public void testParameterMode() {
		Program program = new Program("1002,4,3,4,33");
		assertEquals("1002,4,3,4,99", program.execute());
	}
}
