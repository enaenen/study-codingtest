class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int total = 0;
        int arrayCount = Integer.MAX_VALUE;
        int start = 0;
        int end = 0;

        while (end < nums.length){
            total += nums[end];
            if (total < target){
                end++;
            }
            else {
                while (target <= total){
                    arrayCount = Math.min(arrayCount, end - start + 1);
                    total -= nums[start++];
                }
                end++;
            }
        }
        if (start == 0) return 0;
        return arrayCount;
    }
}