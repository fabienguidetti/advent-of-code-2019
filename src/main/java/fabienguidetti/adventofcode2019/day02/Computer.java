package fabienguidetti.adventofcode2019.day02;

import java.util.List;

class Computer {
	static List<Integer> execute(List<Integer> input) {
		return executeRecursively(input, 0);
	}

	private static List<Integer> executeRecursively(List<Integer> program, int position) {
		int opcode = program.get(position);
		if (opcode == 99) {
			return program;
		} else if (opcode == 1) {
			writeValue(program, position + 3, readValue(program, position + 1) + readValue(program, position + 2));
			return executeRecursively(program, position + 4);
		} else if (opcode == 2) {
			writeValue(program, position + 3, readValue(program, position + 1) * readValue(program, position + 2));
			return executeRecursively(program, position + 4);
		} else {
			throw new IllegalArgumentException("Unknown opcode : " + opcode);
		}
	}

	private static int readValue(List<Integer> program, int addressPosition) {
		int valuePosition = program.get(addressPosition);
		return program.get(valuePosition);
	}

	private static void writeValue(List<Integer> program, int addressPosition, int value) {
		int valuePosition = program.get(addressPosition);
		program.set(valuePosition, value);
	}
}
