package fabienguidetti.adventofcode2019.computer;

import java.util.List;

import fabienguidetti.adventofcode2019.util.Utils;

public class Program {
	private int input;
	private int output;
	private List<Integer> state;

	public Program(String programText) {
		this.state = Utils.splitIntegers(programText);
	}

	public String execute() {
		return Utils.joinIntegers(executeRecursively(0));
	}

	public void setInput(int n) {
		input = n;
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

	private List<Integer> executeRecursively(int position) {
		int instruction = state.get(position);
		int opcode = instruction % 100;
		if (opcode == 99) {
			return state;
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
			parameterModeOf(instruction, 1).writeValue(state, position + 1, input);
			return executeRecursively(position + 2);
		} else if (opcode == 4) {
			output = parameterModeOf(instruction, 1).readValue(state, position + 1);
			return executeRecursively(position + 2);
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
