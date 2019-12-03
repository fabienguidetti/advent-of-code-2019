package fabienguidetti.adventofcode2019.day02;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import fabienguidetti.adventofcode2019.util.Utils;

public class Puzzle2 {
	public static void main(String[] args) throws IOException {
		String inputString = Files.readAllLines(Paths.get("day-02-input.txt")).get(0);
		for (int noun = 0; noun <= 99; noun++) {
			for (int verb = 0; verb <= 99; verb++) {
				List<Integer> input = Utils.splitIntegers(inputString);
				applyNounAndVerb(input, noun, verb);
				List<Integer> output = Computer.execute(input);
				if (output.get(0) == 19690720) {
					System.out.println("Found noun : " + noun);
					System.out.println("Found verb : " + verb);
				}
			}
		}
	}

	private static void applyNounAndVerb(List<Integer> input, int noun, int verb) {
		input.set(1, noun);
		input.set(2, verb);
	}
}
