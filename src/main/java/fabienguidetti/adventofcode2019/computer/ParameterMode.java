package fabienguidetti.adventofcode2019.computer;

import java.util.List;

public abstract class ParameterMode {
	private static final ParameterMode POSITION = new ParameterModePosition();
	private static final ParameterMode IMMEDIATE = new ParameterModeImmediate();

	public static ParameterMode of(int code) {
		if (code == 0) {
			return POSITION;
		} else if (code == 1) {
			return IMMEDIATE;
		} else {
			throw new IllegalArgumentException("Unknown parameter mode : " + code);
		}
	}

	public abstract int readValue(List<Integer> state, int position);
	public abstract void writeValue(List<Integer> state, int addressPosition, int value);

	private static class ParameterModePosition extends ParameterMode {

		@Override
		public int readValue(List<Integer> state, int addressPosition) {
			int valuePosition = state.get(addressPosition);
			return state.get(valuePosition);
		}

		@Override
		public void writeValue(List<Integer> state, int addressPosition, int value) {
			int valuePosition = state.get(addressPosition);
			state.set(valuePosition, value);
		}
	}

	private static class ParameterModeImmediate extends ParameterMode {

		@Override
		public int readValue(List<Integer> state, int addressPosition) {
			int valuePosition = state.get(addressPosition);
			return state.get(valuePosition);
		}

		@Override
		public void writeValue(List<Integer> state, int addressPosition, int value) {
			int valuePosition = state.get(addressPosition);
			state.set(valuePosition, value);
		}
	}
}
