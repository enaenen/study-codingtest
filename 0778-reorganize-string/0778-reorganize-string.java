class Solution {
    public String reorganizeString(String s) {
        Map<Character, Integer> map = new HashMap<>();
        
        for (char c : s.toCharArray()){
            int count = map.getOrDefault(c, 0) + 1;
            //남은 길이보다, 현재 알파벳 수가 많으면 무조건 겹침 
            if ((s.length() + 1)  / 2 < count) return "";
            map.put(c, count);
        }

        // 등장 횟수 기준으로 PQ 내림차순 정렬 
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        for (char c : map.keySet()) pq.add(new int[] {c, map.get(c)} );

        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()){
            int[] first = pq.poll();
            // 겹치지 않는 경우
            if (sb.length() == 0 || first[0] != sb.charAt(sb.length() - 1)) {
                sb.append((char) first[0]);
                if (0 < --first[1]) pq.add(first);
            }
            else {
                // 현재 sb와 중복인 경우
                int[] second = pq.poll();
                sb.append((char) second[0]);
                if (0 < --second[1]) pq.add(second);
                pq.add(first);
            }
        }
        return sb.toString();
    }
}