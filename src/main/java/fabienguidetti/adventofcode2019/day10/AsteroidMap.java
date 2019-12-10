package fabienguidetti.adventofcode2019.day10;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

class AsteroidMap {
	private Set<Asteroid> asteroids = new HashSet<>();

	public static AsteroidMap load(List<String> mapText) {
		return new AsteroidMap(mapText);
	}

	public String bestLocation() {
		int maxDetected = Integer.MIN_VALUE;
		Asteroid bestLocation = null;
		for (Asteroid location : asteroids) {
			int detectedFromLocation = 0;
			for (Asteroid detected : asteroids) {
				if (detected != location) {
					boolean blocked = false;
					for (Asteroid blocking : asteroids) {
						if (blocking != detected && blocking != location) {
							if (blocking.isBetween(location, detected)) {
								blocked = true;
							}
						}
					}
					if (!blocked) {
						detectedFromLocation++;
					}
				}
			}
			if (detectedFromLocation > maxDetected) {
				maxDetected = detectedFromLocation;
				bestLocation = location;
			}
		}
		return "Best is " + bestLocation.getX() + "," + bestLocation.getY() + " with " + maxDetected + " other asteroids detected";
	}

	private AsteroidMap(List<String> mapText) {
		for (int y=0; y < mapText.size(); y++) {
			String[] line = mapText.get(y).split("");
			for (int x=0; x < line.length; x++) {
				if ("#".equals(line[x])) {
					asteroids.add(Asteroid.ofCoordinates(x, y));
				}
			}
		}
	}
}
