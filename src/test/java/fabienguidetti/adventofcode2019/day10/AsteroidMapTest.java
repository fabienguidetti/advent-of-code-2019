package fabienguidetti.adventofcode2019.day10;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

public class AsteroidMapTest {
	@Test
	public void testExampleMap1() {
		List<String> map1Text = Arrays.asList(
				".#..#",
				".....",
				"#####",
				"....#",
				"...##");
		AsteroidMap map1 = AsteroidMap.load(map1Text);
		assertEquals("Best is 3,4 with 8 other asteroids detected", map1.bestLocation());
	}

	@Test
	public void testExampleMap2() {
		List<String> map2Text = Arrays.asList(
				"......#.#.",
				"#..#.#....",
				"..#######.",
				".#.#.###..",
				".#..#.....",
				"..#....#.#",
				"#..#....#.",
				".##.#..###",
				"##...#..#.",
				".#....####");
		AsteroidMap map2 = AsteroidMap.load(map2Text);
		assertEquals("Best is 5,8 with 33 other asteroids detected", map2.bestLocation());
	}

	@Test
	public void testExampleMap3() {
		List<String> map3Text = Arrays.asList(
				"#.#...#.#.",
				".###....#.",
				".#....#...",
				"##.#.#.#.#",
				"....#.#.#.",
				".##..###.#",
				"..#...##..",
				"..##....##",
				"......#...",
				".####.###.");
		AsteroidMap map3 = AsteroidMap.load(map3Text);
		assertEquals("Best is 1,2 with 35 other asteroids detected", map3.bestLocation());
	}

	@Test
	public void testExampleMap4() {
		List<String> map4Text = Arrays.asList(
				".#..#..###",
				"####.###.#",
				"....###.#.",
				"..###.##.#",
				"##.##.#.#.",
				"....###..#",
				"..#.#..#.#",
				"#..#.#.###",
				".##...##.#",
				".....#.#..");
		AsteroidMap map4 = AsteroidMap.load(map4Text);
		assertEquals("Best is 6,3 with 41 other asteroids detected", map4.bestLocation());
	}

	@Test
	public void testExampleMap5() {
		List<String> map5Text = Arrays.asList(
				".#..##.###...#######",
				"##.############..##.",
				".#.######.########.#",
				".###.#######.####.#.",
				"#####.##.#.##.###.##",
				"..#####..#.#########",
				"####################",
				"#.####....###.#.#.##",
				"##.#################",
				"#####.##.###..####..",
				"..######..##.#######",
				"####.##.####...##..#",
				".#####..#.######.###",
				"##...#.##########...",
				"#.##########.#######",
				".####.#.###.###.#.##",
				"....##.##.###..#####",
				".#.#.###########.###",
				"#.#.#.#####.####.###",
				"###.##.####.##.#..##");
		AsteroidMap map5 = AsteroidMap.load(map5Text);
		assertEquals("Best is 11,13 with 210 other asteroids detected", map5.bestLocation());
	}
}
