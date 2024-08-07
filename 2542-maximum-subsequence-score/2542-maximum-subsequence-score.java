class Solution {
    public long maxScore(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;
        int[][] scoreSet = new int[n][2];
        
        for (int i = 0; i < n; i++) scoreSet[i] = new int[] {nums1[i], nums2[i]};

        Arrays.sort(scoreSet, (o1, o2) -> o2[1] - o1[1]);
        PriorityQueue<Integer> pq = new PriorityQueue<>(k, (o1, o2) -> o1 - o2);
        long result = 0, sum = 0;
        for (int[] scores : scoreSet){
            pq.offer(scores[0]);
            sum += scores[0];
            if (pq.size() > k) sum -= pq.poll();
            if (pq.size() == k) result = Math.max(result, (sum * scores[1]));
        }
        return result;
    }
}