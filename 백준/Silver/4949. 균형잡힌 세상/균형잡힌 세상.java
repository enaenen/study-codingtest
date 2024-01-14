import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        StringBuffer answer = new StringBuffer();
        Stack braceletStack = new Stack<Character>();
        String opens = "({[";
        String closes = ")}]";
        while (!line.equals(".")) {
            boolean isError = false;
            for (int i = 0; i < line.length(); i++) {
                if (line.charAt(i) == '(' || line.charAt(i) == '{' || line.charAt(i) == '[') {
                    braceletStack.push(line.charAt(i));
                } else if (line.charAt(i) == ')' || line.charAt(i) == '}' || line.charAt(i) == ']') {

                    if (braceletStack.isEmpty()) {
                        isError = true;
                        break;
                    }
                    for (int j = 0; j < closes.length(); j++) {
                        if (line.charAt(i) == closes.charAt(j))
                            if ((char) braceletStack.peek() != opens.charAt(j)) {
                                isError = true;
                                break;
                            }
                    }
                    braceletStack.pop();
                }
            }
            if (!braceletStack.isEmpty() || isError)
                answer.append("no\n");
            else
                answer.append("yes\n");
            braceletStack.clear();
            line = br.readLine();
        }
        System.out.println(answer.toString());
    }
}
