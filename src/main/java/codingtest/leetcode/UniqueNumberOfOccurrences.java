package codingtest.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
//
public class UniqueNumberOfOccurrences {

	public static void main(String[] args) {
		System.out.println(uniqueOccurrences(new int[] {1,2,2,1,1,3}));
		System.out.println(uniqueOccurrences(new int[] {1,2}));

	}
	public static boolean uniqueOccurrences(int[] arr) {
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i : arr) {
			map.put(i, map.getOrDefault(i , 0) + 1);
		}
//1ms 차이
		//		Set<Integer> uniqueValues = new HashSet<>();
//		for (Integer value : map.values()) {
//			if (!uniqueValues.add(value)) {
//				return false; // 중복된 값이 발견되면 false 반환
//			}
//		}
//		return true;
		return map.values().stream().distinct().count() == map.size();
	}

}
