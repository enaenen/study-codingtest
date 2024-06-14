import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        int answer = 0;
        Map<String, Map<String, Integer>> giveHistory = new HashMap<String, Map<String,Integer>>();
        Map<String, Integer> giftIndex = new HashMap<>(); //선물지수
        Map<String, Integer> sums = new HashMap<String, Integer>(); //받게될 선물 저장
        
        for (String name : friends){
            giveHistory.put(name, new HashMap<>());
            giftIndex.put(name, 0);
            sums.put(name, 0);
        }
        
        for (String one : gifts){
            String[] giveAndTake = one.split(" ");
            String giver = giveAndTake[0];
            String receiver = giveAndTake[1];
            
            giveHistory.get(giver).put(receiver, giveHistory.get(giver).getOrDefault(receiver, 0) + 1);
            giftIndex.put(giver, giftIndex.get(giver) + 1);
            giftIndex.put(receiver, giftIndex.get(receiver) - 1);
            
        }
        
  
        for (String giver : friends){
            for (String receiver : friends){
                if (giver.equals(receiver)) continue;
                int giversGiving = giveHistory.get(giver).getOrDefault(receiver, 0);
                int giversTake = giveHistory.get(receiver).getOrDefault(giver, 0);
                if (giversGiving > giversTake){
                    sums.put(giver, sums.get(giver) + 1);
                }
                else if (giversGiving == giversTake){
                    if (giftIndex.get(giver) > giftIndex.get(receiver))
                        sums.put(giver, sums.get(giver) + 1);
                }
            }
        }
        
        return Collections.max(sums.values());
    }
}