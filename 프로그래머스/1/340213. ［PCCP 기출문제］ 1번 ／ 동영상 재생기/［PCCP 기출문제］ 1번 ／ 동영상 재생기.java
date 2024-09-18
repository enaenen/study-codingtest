import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

class Solution {
    private static final LocalTime startTime = LocalTime.MIN;
    private static LocalTime endTime;
    private static LocalTime opStart;
    private static LocalTime opEnd;

    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        endTime = LocalTime.parse("00:" + video_len, formatter);
        LocalTime current = LocalTime.parse("00:" + pos, formatter);
        opStart =  LocalTime.parse("00:" + op_start, formatter);
        opEnd =  LocalTime.parse("00:" + op_end, formatter);

        
        //command 분류
        for (String cmd : commands) {
            //오프닝 범위일경우 오프닝 끝시간으로
            if (!current.isBefore(opStart) && !current.isAfter(opEnd)){
                current = opEnd;
            }
            
            if (cmd.equals("next")){ // 10초 후가 end 보다 이후면 끝시간으로 , 그게 아니면 현재 + 10
                if (current.plusSeconds(10).isAfter(endTime)) current = endTime;
                else current = current.plusSeconds(10);
            }
            
            
            else{ // 10초 전이 start 보다 이전이면 start로, 그게 아니면 현재 - 10초
                LocalTime tmp = current.minusSeconds(10);
                if (tmp.isBefore(startTime) || tmp.isAfter(current)) current = startTime;
                else current = current.minusSeconds(10);
            }
        }
        // 끝난 이후 오프닝시간이면, 건너뛰기
        if (!current.isBefore(opStart) && !current.isAfter(opEnd)){
            current = opEnd;
        }
        
        return String.format("%02d:%02d", current.getMinute(), current.getSecond());
    }
}