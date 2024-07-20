import java.io.*;
class Main {
	public static int countingChar(String str, char delim){
		int result = 0;
		for (char c : str.toCharArray()){
			if (c == delim) result++;
		}
		return result;
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		System.out.println(countingChar(input, '1'));
		System.out.println(countingChar(input, 'I'));
		System.out.println(countingChar(input, 'l'));
		System.out.println(countingChar(input, '|'));
	}
}