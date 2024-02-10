import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        for (int i = 0; i < n; i++){
            for (int j = n - 1; j > i; j--){
                if (arr[i] > arr[j]){
                    int tmp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = tmp;
                }
            }
        }
        StringBuffer sb = new StringBuffer();
        for (int i : arr){
            sb.append(i +"\n");
        }
        System.out.println(sb.toString());
    }
}