package fabienguidetti.adventofcode2019.day05;

import fabienguidetti.adventofcode2019.computer.Program;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Puzzle1 {
	public static void main(String[] args) throws IOException {
		String inputString = Files.readAllLines(Paths.get("day-05-input.txt")).get(0);
		Program program = new Program(inputString);
		program.input(1);
		program.execute();
		System.out.println("Program output : " + program.getOutput());
	}
}
