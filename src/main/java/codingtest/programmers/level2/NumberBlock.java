package codingtest.programmers.level2;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

/*
https://school.programmers.co.kr/learn/courses/30/lessons/12923
 */
public class NumberBlock {
    public static void main(String[] args) {
        int[] solution = solution(1, 10);
        System.out.println(solution);
    }

    public static int[] solution(long begin, long end) {
        int maxValue = 1000000000;
        List<Long> list = new ArrayList<>();

        for(long i = begin; i<=end; i++){
            long result = 1;
            if (i == 1){
                list.add(0L);
                continue;
            }

            for(long j = 2; j * j <= i; j++){
                if (i % j == 0){
                    result = j;

                    if (i / j <= maxValue){
                        result = i / j;
                        break;
                    }
                }
            }
            list.add(result);
        }
        int[] answer = list.stream().mapToInt(Long::intValue).toArray();
        return answer;
    }
}
