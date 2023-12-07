package codingtest.programmers.level2;

import java.util.ArrayList;
import java.util.List;

public class VowelDictionary {

	//https://school.programmers.co.kr/learn/courses/30/lessons/84512
	public static void main(String[] args) {
		System.out.println(solution("AAAAE"));
		System.out.println(solution("AAAE"));
		System.out.println(solution("I"));
		System.out.println(solution("EIO"));
	}

	private static final String vowels = "AEIOU";
	private static final List<String> dictionary = new ArrayList<>();

	public static int solution(String word) {
		int answer = 0;
		setDictionary("");
		for (String s : dictionary) {
			if (s.equals(word)) {
				break;
			}
			answer++;
		}
		return answer;
	}

	private static void setDictionary(String str) {
		dictionary.add(str);
		if (str.length() == 5) {
			return;
		}
		for (int i = 0; i < vowels.length(); i++) {
			setDictionary(str + vowels.charAt(i));
		}
	}
}

//1 A
//2 AA
//3 AAA
//4 AAAA
//5 AAAAA
//6 AAAAE
//7 AAAAI
//8 AAAAO
//9 AAAAU
//10 AAAE
//11 AAAEA
//12 AAAEE
//13 AAAEI
//14 AAAEO
//15 AAAEU
//16 AAAI
//17 AAAIA
//18 AAAII
//19 AAAIE
//20 AAAIO
//21 AAAIU
//22 AAAO