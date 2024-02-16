package codingtest.basic.recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Modular {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int a = Integer.parseInt(br.readLine());
		int b = Integer.parseInt(br.readLine());
		int mod = Integer.parseInt(br.readLine());
//		System.out.println(calcPOW(10, 11, 12));
		System.out.println(calcPOW(a, b, mod));
	}

	public static long calcPOW(int a, int b, int mod) {
		if (b == 0) {
			return 1;
		}
		long n = calcPOW(a, b / 2, mod);
		if (b % 2 == 0) {
			return n * n % mod;
		} else {
			return (n * n % mod) * a % mod;
		}
	}


}
