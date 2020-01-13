package fabienguidetti.adventofcode2019.day12;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class System {
	List<Moon> moons = new ArrayList<>();

	public void addMoonOf(String moonString) {
		moons.add(Moon.of(moonString));
	}

	public Moon moon(int index) {
		return moons.get(index);
	}

	public void moveOneStep() {
		moons.stream().forEach(this::applyGravity);
		moons.stream().forEach(this::applyVelocity);
	}

	public int totalEnergy() {
		return moons.stream().collect(Collectors.summingInt(m -> m.totalEnergy()));
	}

	private void applyGravity(Moon moon) {
		for (Moon other : moons) {
			moon.applyGravity(other);
		}
	}

	private void applyVelocity(Moon moon) {
		moon.applyVelocity();
	}
}
