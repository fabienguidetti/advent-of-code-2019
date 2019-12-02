package fabienguidetti.adventofcode2019.day02;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Puzzle1 {
	public static void main(String[] args) throws IOException {
		String inputString = Files.readAllLines(Paths.get("day-02-input.txt")).get(0);
		List<Integer> input = Utils.splitIntegers(inputString);
		restore1202ProgramAlarm(input);
		List<Integer> output = Computer.execute(input);
		System.out.println("Program output : " + output);
	}

	private static void restore1202ProgramAlarm(List<Integer> input) {
		input.set(1, 12);
		input.set(2, 2);
	}
}
