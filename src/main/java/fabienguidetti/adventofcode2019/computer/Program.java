package fabienguidetti.adventofcode2019.computer;

import java.util.List;

import fabienguidetti.adventofcode2019.util.Utils;

public class Program {
	private int input;
	private int output;
	private List<Integer> state;

	private static final ParameterMode POSITION_MODE = ParameterMode.of(0);

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
		int opcode = state.get(position);
		if (opcode == 99) {
			return state;
		} else if (opcode == 1) {
			int value1 = POSITION_MODE.readValue(state, position + 1);
			int value2 = POSITION_MODE.readValue(state, position + 2);
			POSITION_MODE.writeValue(state, position + 3, value1 + value2);
			return executeRecursively(position + 4);
		} else if (opcode == 2) {
			int value1 = POSITION_MODE.readValue(state, position + 1);
			int value2 = POSITION_MODE.readValue(state, position + 2);
			POSITION_MODE.writeValue(state, position + 3, value1 * value2);
			return executeRecursively(position + 4);
		} else if (opcode == 3) {
			POSITION_MODE.writeValue(state, position + 1, input);
			return executeRecursively(position + 2);
		} else if (opcode == 4) {
			output = POSITION_MODE.readValue(state, position + 1);
			return executeRecursively(position + 2);
		} else {
			throw new IllegalArgumentException("Unknown opcode : " + opcode);
		}
	}
}
