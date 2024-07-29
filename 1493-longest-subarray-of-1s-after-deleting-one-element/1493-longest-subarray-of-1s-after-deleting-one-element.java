class Solution {
    public int longestSubarray(int[] nums) {
        int lt = 0;
        int zero = 0;
        int result = 0;
        for (int rt = 0; rt < nums.length; rt++){
            if (nums[rt] == 0) zero++;
            while (1 < zero){
                if (nums[lt] == 0) zero--;
                lt++;
            }
            result = Math.max(result, rt - lt + 1 - zero);
        }
        if (result == nums.length) return result - 1;
        else return result;
    }
}