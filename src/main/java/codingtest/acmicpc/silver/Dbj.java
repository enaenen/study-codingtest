package codingtest.acmicpc.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class Dbj {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int n = Integer.parseInt(input[0]);
		int m = Integer.parseInt(input[1]);

		HashSet<String> neverHeard = new HashSet<>();
		HashSet<String> neverSeen = new HashSet<>();

		for (int i = 0; i < n; i++) {
			neverHeard.add(br.readLine());
		}
		for (int i = 0; i < m; i++) {
			neverSeen.add(br.readLine());
		}

		List<String> list = neverHeard.stream().filter(neverSeen::contains).sorted().collect(
				Collectors.toList());
		StringBuilder sb = new StringBuilder();
		sb.append(list.size()).append("\n");
		for (String s : list) {
			sb.append(s).append("\n");
		}
		System.out.println(sb);
	}
}
