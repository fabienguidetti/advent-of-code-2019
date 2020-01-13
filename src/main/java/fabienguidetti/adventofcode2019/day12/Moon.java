package fabienguidetti.adventofcode2019.day12;

import java.util.Scanner;
import java.util.regex.MatchResult;

public class Moon {
	private int positionX;
	private int positionY;
	private int positionZ;
	private int velocityX;
	private int velocityY;
	private int velocityZ;

	public static Moon of(String moonString) {
		Scanner scanner = new Scanner(moonString);
		scanner.findInLine("<x=(.+), y=(.+), z=(.+)>");
		MatchResult result = scanner.match();
		int positionX = Integer.valueOf(result.group(1));
		int positionY = Integer.valueOf(result.group(2));
		int positionZ = Integer.valueOf(result.group(3));
		scanner.close();
		return new Moon(positionX, positionY, positionZ);
	}

	private Moon(int x, int y, int z) {
		positionX = x;
		positionY = y;
		positionZ = z;
	}

	public void applyGravity(Moon other) {
		velocityX += signum(other.positionX - positionX);
		velocityY += signum(other.positionY - positionY);
		velocityZ += signum(other.positionZ - positionZ);
	}

	public void applyVelocity() {
		positionX += velocityX;
		positionY += velocityY;
		positionZ += velocityZ;
	}

	public int totalEnergy() {
		return potentialEnergy() * kineticEnergy();
	}

	private int potentialEnergy() {
		return Math.abs(positionX) + Math.abs(positionY) + Math.abs(positionZ);
	}

	private int kineticEnergy() {
		return Math.abs(velocityX) + Math.abs(velocityY) + Math.abs(velocityZ);
	}

	public int positionX() {
		return positionX;
	}

	public int positionY() {
		return positionY;
	}

	public int positionZ() {
		return positionZ;
	}

	public int velocityX() {
		return velocityX;
	}

	public int velocityY() {
		return velocityY;
	}

	public int velocityZ() {
		return velocityZ;
	}

	private int signum(int value) {
		if (value < 0) {
			return -1;
		} else if (value > 0) {
			return 1;
		} else {
			return 0;
		}
	}
}
