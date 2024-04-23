class Solution {
    class Combination {
        int count;
        String num;

        public Combination(int count, String num){
            this.count = count;
            this.num = num;
        }
    }
    public int openLock(String[] deadends, String target) {
        if (target.equals("0000"))
            return 0;
    
        Set<String> deadSet = new HashSet<>(Arrays.asList(deadends));
        if(deadSet.contains("0000"))
            return -1;

        Deque<Combination> que = new LinkedList<>();
        Set<String> visited = new HashSet<>();
   

        que.offer(new Combination(0,"0000"));
        while (!que.isEmpty()){
            Combination cur = que.poll();
            String currentNum = cur.num;
            int moves = cur.count;

            if (currentNum.equals(target))
                return moves;
            
            for (int i = 0; i < 4; i++){
                for (int dir : new int[]{-1, 1}){
                    int next = (currentNum.charAt(i) - '0' + dir + 10) % 10;
                    String nextNum = currentNum.substring(0, i) + next + currentNum.substring(i + 1);
                    if (!deadSet.contains(nextNum) && !visited.contains(nextNum)){
                        visited.add(nextNum);
                        que.offer(new Combination(moves + 1, nextNum));
                    }
                }
            }
        }
        return -1;
    }
}