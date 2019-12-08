package fabienguidetti.adventofcode2019.computer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import fabienguidetti.adventofcode2019.util.Utils;

public class Program {
	public static final String DELIMITER = ",";

	private List<Integer> input = new ArrayList<>();
	private int inputIndex = 0;

	private int output;
	private boolean hasOutput = false;

	private List<Integer> state;
	private int position = 0;

	public Program(String programText) {
		this.state = Utils.splitIntegers(programText, DELIMITER);
	}

	public String execute() {
		while (executeUntilOutput()) {
		}
		return Utils.joinIntegers(state, DELIMITER);
	}

	public boolean executeUntilOutput() {
		hasOutput = false;
		position = executeRecursively(position);
		return hasOutput;
	}

	public void input(int... ns) {
		for (int n : ns) {
			input.add(n);
		}
	}

	public void setNoun(int n) {
		state.set(1, n);
	}

	public void setVerb(int n) {
		state.set(2, n);
	}

	public int getOutput() {
		return output;
	}

	public void restore1202ProgramAlarm() {
		setNoun(12);
		setVerb(2);
	}

	private int executeRecursively(int position) {
		int instruction = state.get(position);
		int opcode = instruction % 100;
		if (opcode == 99) {
			return position;
		} else if (opcode == 1) {
			int value1 = parameterModeOf(instruction, 1).readValue(state, position + 1);
			int value2 = parameterModeOf(instruction, 2).readValue(state, position + 2);
			parameterModeOf(instruction, 3).writeValue(state, position + 3, value1 + value2);
			return executeRecursively(position + 4);
		} else if (opcode == 2) {
			int value1 = parameterModeOf(instruction, 1).readValue(state, position + 1);
			int value2 = parameterModeOf(instruction, 2).readValue(state, position + 2);
			parameterModeOf(instruction, 3).writeValue(state, position + 3, value1 * value2);
			return executeRecursively(position + 4);
		} else if (opcode == 3) {
			parameterModeOf(instruction, 1).writeValue(state, position + 1, input.get(inputIndex++));
			return executeRecursively(position + 2);
		} else if (opcode == 4) {
			output = parameterModeOf(instruction, 1).readValue(state, position + 1);
			hasOutput = true;
			return position + 2;
		} else if (opcode == 5) {
			int value1 = parameterModeOf(instruction, 1).readValue(state, position + 1);
			if (value1 != 0) {
				int value2 = parameterModeOf(instruction, 2).readValue(state, position + 2);
				return executeRecursively(value2);
			} else {
				return executeRecursively(position + 3);
			}
		} else if (opcode == 6) {
			int value1 = parameterModeOf(instruction, 1).readValue(state, position + 1);
			if (value1 == 0) {
				int value2 = parameterModeOf(instruction, 2).readValue(state, position + 2);
				return executeRecursively(value2);
			} else {
				return executeRecursively(position + 3);
			}
		} else if (opcode == 7) {
			int value1 = parameterModeOf(instruction, 1).readValue(state, position + 1);
			int value2 = parameterModeOf(instruction, 2).readValue(state, position + 2);
			parameterModeOf(instruction, 3).writeValue(state, position + 3, value1 < value2 ? 1 : 0);
			return executeRecursively(position + 4);
		} else if (opcode == 8) {
			int value1 = parameterModeOf(instruction, 1).readValue(state, position + 1);
			int value2 = parameterModeOf(instruction, 2).readValue(state, position + 2);
			parameterModeOf(instruction, 3).writeValue(state, position + 3, value1 == value2 ? 1 : 0);
			return executeRecursively(position + 4);
		} else {
			throw new IllegalArgumentException("Unknown opcode : " + opcode);
		}
	}

	private ParameterMode parameterModeOf(int opcode, int paramPosition) {
		int powerOf10 = powerOf10(paramPosition + 1);
		int modeCode = (opcode / powerOf10) % 10;
		return ParameterMode.of(modeCode);
	}

	private int powerOf10(int power) {
		int result = 1;
		for (int i=1; i <= power; i++) {
			result *= 10;
		}
		return result;
	}
}
