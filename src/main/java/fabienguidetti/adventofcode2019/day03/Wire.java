package fabienguidetti.adventofcode2019.day03;

import java.awt.Point;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Wire {
	private List<Segment> segments;

	Wire(String path) {
		segments = new ArrayList<>();
		for (String s : path.split(",")) {
			segments.add(Segment.valueOf(s));
		}
	}

	Set<Point> locations() {
		Set<Point> locations = new HashSet<>();
		Point start = new Point(0, 0);
		for (Segment segment : segments) {
			List<Point> segmentLocations = segment.locationsFrom(start);
			locations.addAll(segmentLocations);
			start = segmentLocations.get(segmentLocations.size() - 1);
		}
		return locations;
	}
}
