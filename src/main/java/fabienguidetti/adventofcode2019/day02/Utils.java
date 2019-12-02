package fabienguidetti.adventofcode2019.day02;

import java.util.ArrayList;
import java.util.List;

public class Utils {
	static List<Integer> splitIntegers(String stringOfIntegers) {
		String[] integerStrings = stringOfIntegers.split(",");
		List<Integer> integers = new ArrayList<>();
		for (String s : integerStrings) {
			integers.add(Integer.valueOf(s));
		}
		return integers;
	}

	static String joinIntegers(List<Integer> integers) {
		List<String> strings = new ArrayList<>();
		for (Integer n : integers) {
			strings.add(Integer.toString(n));
		}
		return String.join(",", strings);
	}
}
