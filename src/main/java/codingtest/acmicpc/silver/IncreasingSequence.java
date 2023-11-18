package codingtest.acmicpc.silver;
// https://www.acmicpc.net/problem/11055
// 증가하는 수열

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class IncreasingSequence {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] sequence = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] memo = new int[n];
        int result = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (sequence[i] > sequence[j]) {
                    memo[i] = Math.max(memo[i], memo[j] + sequence[i]);
                }
            }
            result = Math.max(result, memo[i]);
        }
        System.out.println(result);
    }
}
