import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputTime = br.readLine().split(" ");
        String cooking = br.readLine();
        
        int cookingTime = Integer.parseInt(cooking);
        int spendHours = cookingTime / 60;
        int spendMinutes = cookingTime % 60;

        int afterMinutes = (Integer.parseInt(inputTime[1]) + spendMinutes);
        int afterHours = (Integer.parseInt(inputTime[0]) + spendHours);
        
        afterHours += afterMinutes / 60;
        afterMinutes %= 60;
        afterHours %= 24;

        System.out.println(afterHours + " " + afterMinutes);
    }
}