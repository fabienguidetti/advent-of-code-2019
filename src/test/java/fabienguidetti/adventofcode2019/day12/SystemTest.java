package fabienguidetti.adventofcode2019.day12;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class SystemTest {
	@Test
	public void testExample1() {
		System system = new System();
		system.addMoonOf("<x=-1, y=0, z=2>");
		system.addMoonOf("<x=2, y=-10, z=-7>");
		system.addMoonOf("<x=4, y=-8, z=8>");
		system.addMoonOf("<x=3, y=5, z=-1>");

		system.moveOneStep();

		MoonTest.assertPosition(2, -1, 1, system.moon(0));
		MoonTest.assertVelocity(3, -1, -1, system.moon(0));

		MoonTest.assertPosition(3, -7, -4, system.moon(1));
		MoonTest.assertVelocity(1, 3, 3, system.moon(1));

		MoonTest.assertPosition(1, -7, 5, system.moon(2));
		MoonTest.assertVelocity(-3, 1, -3, system.moon(2));

		MoonTest.assertPosition(2, 2, 0, system.moon(3));
		MoonTest.assertVelocity(-1, -3, 1, system.moon(3));

		for (int step = 2; step <= 10; step++) {
			system.moveOneStep();
		}

		MoonTest.assertPosition(2, 1, -3, system.moon(0));
		MoonTest.assertVelocity(-3, -2, 1, system.moon(0));

		MoonTest.assertPosition(1, -8, 0, system.moon(1));
		MoonTest.assertVelocity(-1, 1, 3, system.moon(1));

		MoonTest.assertPosition(3, -6, 1, system.moon(2));
		MoonTest.assertVelocity(3, 2, -3, system.moon(2));

		MoonTest.assertPosition(2, 0, 4, system.moon(3));
		MoonTest.assertVelocity(1, -1, -1, system.moon(3));

		assertEquals(179, system.totalEnergy());
	}
}
