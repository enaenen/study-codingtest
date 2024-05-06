package codingtest.collections.map;

import java.util.Collections;
import java.util.Map;
import java.util.Map.Entry;

public class HashMapSorting {

	public static void main(String[] args) {
		Map<String, Integer> map = Map.of("a", 1, "b", 2, "c", 3, "d", 4, "e", 5);
		//value ascending order
		map.entrySet().stream()
				.sorted(Map.Entry.comparingByValue())
				.forEach(System.out::println);

		//value descending order
		map.entrySet().stream()
				.sorted(Map.Entry.comparingByValue((o1, o2) -> o2 - o1))
				.forEach(System.out::println);

		//max
		Entry<String, Integer> max = Collections.max(map.entrySet(), Entry.comparingByValue());
		System.out.println("max = " + max);
		//min
		Entry<String, Integer> min = Collections.min(map.entrySet(), Entry.comparingByValue());
		System.out.println("min = " + min);
	}

}
