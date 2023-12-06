package codingtest.inflearn.array;
//problem02-09


/**
 * N*N의 격자판이 주어지면 각 행의 합, 각 열의 합, 두 대각선의 합 중 가 장 큰 합을 출력합니다.
 * <p>
 * 첫 줄에 자연수 N이 주어진다.(2<=N<=50)
 * <p>
 * 두 번째 줄부터 N줄에 걸쳐 각 줄에 N개의 자연수가 주어진다. 각 자연수는 100을 넘지 않는다.
 * <p>
 **/
		/*
 5
10 13 10 12 15
12 39 30 23 11
11 25 50 53 15
19 27 29 37 27
19 13 30 13 19

 answer 155

 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BoardMax {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] arr = new int[n][n];
		int max = 0;
		int oneLineMax;
		for (int i = 0; i < n; i++) {
			oneLineMax = 0;
			String[] line = br.readLine().split(" ");
			for (int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(line[j]);
				oneLineMax += arr[i][j];
			}
			max = Math.max(max, oneLineMax);
		}
		for (int i = 0; i < n; i++) {
			oneLineMax = 0;
			for (int j = 0; j < n; j++) {
				oneLineMax+= arr[j][i];
			}
			max = Math.max(max, oneLineMax);
		}
		oneLineMax = 0;
		for (int i = 0; i < n; i++){
			oneLineMax += arr[i][i];
		}
		max = Math.max(max, oneLineMax);

		oneLineMax = 0;
		for (int i = 0; i < n; i++){
			oneLineMax += arr[i][n - 1 - i];
		}
		max = Math.max(max, oneLineMax);

		System.out.println(max);
	}


}
