package fabienguidetti.adventofcode2019.day02;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import fabienguidetti.adventofcode2019.computer.Program;

public class Puzzle1 {
	public static void main(String[] args) throws IOException {
		String inputString = Files.readAllLines(Paths.get("day-02-input.txt")).get(0);
		Program program = new Program(inputString);
		program.restore1202ProgramAlarm();
		System.out.println("Program output : " + program.execute());
	}
}
