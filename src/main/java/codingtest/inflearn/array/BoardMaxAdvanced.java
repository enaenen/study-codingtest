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

public class BoardMaxAdvanced {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] arr = new int[n][n];
		int max = 0;
		int oneLineMax1, oneLineMax2;
		// 가로 합
		for (int i = 0; i < n; i++) {
			oneLineMax1 = oneLineMax2 = 0;
			String[] line = br.readLine().split(" ");
			for (int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(line[j]);
				oneLineMax1 += arr[i][j]; // 가로합
				oneLineMax2 += arr[j][i]; // 세로합
			}
			max = Math.max(max, oneLineMax1);
			max = Math.max(max, oneLineMax2);
		}

		// 양방향 대각선
		oneLineMax1 = 0;
		oneLineMax2 = 0;

		for (int i = 0; i < n; i++){
			oneLineMax1 += arr[i][i]; // 왼위 - 오아래
			oneLineMax2 += arr[i][n - 1 - i]; //오위 -> 왼아래
		}
		max = Math.max(max, oneLineMax1);
		max = Math.max(max, oneLineMax2);

		System.out.println(max);
	}


}
