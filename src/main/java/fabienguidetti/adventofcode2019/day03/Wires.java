package fabienguidetti.adventofcode2019.day03;

import java.awt.Point;
import java.util.Set;
import java.util.stream.Collectors;

class Wires {
	static int crossAtDistance(String path1, String path2) {
		Set<Point> locations1 = new Wire(path1).locations();
		Set<Point> locations2 = new Wire(path2).locations();
		Set<Point> intersection = locations1.stream()
			    .filter(locations2::contains)
			    .collect(Collectors.toSet());
		int minDistance = Integer.MAX_VALUE;
		for (Point p : intersection) {
			int distance = distance(p);
			if (distance < minDistance && distance > 0) {
				minDistance = distance;
			}
		}
		return minDistance;
	}

	private static int distance(Point p) {
		int xDistance = Math.abs(Double.valueOf(p.getX()).intValue());
		int yDistance = Math.abs(Double.valueOf(p.getY()).intValue());
		return xDistance + yDistance;
	}
}
