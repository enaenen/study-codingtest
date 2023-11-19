package codingtest.acmicpc.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * https://www.acmicpc.net/problem/4949
 */
public class BalancedWorldV1 {
    public static void main(String[] args) throws IOException {
        String line = "";

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (line != null) {
            line = br.readLine();
            // 종료조건
            if (line.length() == 1 && line.charAt(0) == '.') {
                line = null;
                break;
            }
            // 구문 분석
            char[] charArray = line.toCharArray();
            Stack<Character> stack = new Stack<>();
            for (int i = 0; i < charArray.length; i++) {
                if (charArray[i] == '(' || charArray[i] == '[') {
                    stack.push(charArray[i]);
                }
                if (charArray[i] == ')' || charArray[i] == ']') {
                    // )( case dummy X add
                    if (stack.isEmpty()){
                        stack.push('X');
                        break;
                    }
                    if (charArray[i] == ')' && stack.peek() == (charArray[i] - 1)) {
                        stack.pop();
                    }
                    if (charArray[i] == ']' && stack.peek() == (charArray[i] - 2)) {
                        stack.pop();
                    }
                }
            }
            if (!stack.empty()) {
                stack.clear();
                System.out.println("no");
            } else {
                System.out.println("yes");
            }
        }
    }
}
