package fabienguidetti.adventofcode2019.day01;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Puzzle2 {
	public static void main(String[] args) throws IOException {
		int totalFuelRequired = 0;
		for (String s : Files.readAllLines(Paths.get("day-01-input.txt"))) {
			int mass = Integer.valueOf(s);
			totalFuelRequired += Module.fuelRequiredWithFuel(mass);
		}
		System.out.println("Total fuel required : " + totalFuelRequired);
	}
}
