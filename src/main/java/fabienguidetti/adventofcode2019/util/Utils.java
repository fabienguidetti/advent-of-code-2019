package fabienguidetti.adventofcode2019.util;

import java.util.ArrayList;
import java.util.List;

public class Utils {
	public static List<Integer> splitIntegers(String stringOfIntegers, String delimiter) {
		String[] integerStrings = stringOfIntegers.split(delimiter);
		List<Integer> integers = new ArrayList<>();
		for (String s : integerStrings) {
			integers.add(Integer.valueOf(s));
		}
		return integers;
	}

	public static String joinIntegers(List<Integer> integers, String delimiter) {
		List<String> strings = new ArrayList<>();
		for (Integer n : integers) {
			strings.add(Integer.toString(n));
		}
		return String.join(delimiter, strings);
	}
}
