package fabienguidetti.adventofcode2019.day06;

import java.util.HashMap;
import java.util.Map;

class OrbitMap {

	private Map<String, String> orbits = new HashMap<>();

	void addOrbit(String center, String satellite) {
		orbits.put(satellite, center);
	}

	int checksum() {
		int result = 0;
		for (String satellite : orbits.keySet()) {
			String object = satellite;
			while (orbits.get(object) != null) {
				result++;
				object = orbits.get(object);
			}
		}
		return result;
	}
}
