package codingtest.acmicpc.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * https://www.acmicpc.net/problem/4949
 */
public class BalancedWorldV2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            Stack<Character> stack = new Stack<>();
            boolean error = false;
            String line = br.readLine();
            if (line.equals(".")) {
                break;
            }
            for (char c : line.toCharArray()) {
                if (c == '(' || c == '['){
                    stack.push(c);
                }
                else if (c == ')'){
                    if (stack.isEmpty() || stack.peek() != '(') {
                        error = true;
                        break;
                    }
                    stack.pop();
                }
                else if ( c == ']'){
                    if (stack.isEmpty() || stack.peek() != '['){
                        error = true;
                        break;
                    }
                    stack.pop();
                }
            }
            if (stack.empty() && !error){
                System.out.println("yes");
            }
            else {
                System.out.println("no");
            }
        }
    }
}
