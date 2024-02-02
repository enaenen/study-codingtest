import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine();
        String explodingWord = br.readLine();
        Stack<Character> stack = new Stack<>();
        
        for (int i = 0 ; i < word.length(); i++){
            stack.push(word.charAt(i));
            boolean isExplode = true;
            if (stack.size() >= explodingWord.length()){
                for (int j = 0; j < explodingWord.length(); j++){
                    if (stack.get(stack.size() - explodingWord.length() + j) != explodingWord.charAt(j)){
                        isExplode = false;
                        break;
                    }
                }
                if (isExplode){
                    for (int j = 0; j < explodingWord.length(); j++){
                        stack.pop();
                    }
                }
            }
        }
        if (stack.isEmpty()){
            System.out.println("FRULA");
            return;
        }
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (Character c : stack){
            bw.write(c);
        }
        bw.close();
    }
}