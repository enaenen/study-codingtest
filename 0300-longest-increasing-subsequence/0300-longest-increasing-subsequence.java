class Solution {
    public int lengthOfLIS(int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue(Collections.reverseOrder());
        pq.offer(nums[0]);

        for (int i = 1; i < nums.length; i++){
            if (nums[i] > pq.peek()) pq.add(nums[i]);
            else {
                // num[i] 보다 같거나 큰 수를 찾음 in subList
                for (int j = 0; j < subList.size(); j++){
                    if (subList.get(j) >= nums[i]) {
                        subList.set(j, nums[i]); 
                        break;
                    }
                }
            }
        }
        return subList.size();
    }
}
