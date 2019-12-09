package fabienguidetti.adventofcode2019.day09;

import fabienguidetti.adventofcode2019.computer.Program;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Puzzle2 {
	public static void main(String[] args) throws IOException {
		String inputString = Files.readAllLines(Paths.get("day-09-input.txt")).get(0);
		Program program = new Program(inputString);
		program.input(2);
		while (program.executeUntilOutput()) {
			System.out.println("Program output : " + program.getOutput());
		}
	}
}
