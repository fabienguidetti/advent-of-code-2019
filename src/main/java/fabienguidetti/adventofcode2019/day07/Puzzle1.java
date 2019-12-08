package fabienguidetti.adventofcode2019.day07;

import fabienguidetti.adventofcode2019.computer.Program;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Puzzle1 {
	public static void main(String[] args) throws IOException {
		String inputString = Files.readAllLines(Paths.get("day-07-input.txt")).get(0);
		Amplifiers amplifiers = new Amplifiers(inputString);
		System.out.println("Max signal : " + amplifiers.maxSignal());
	}
}
