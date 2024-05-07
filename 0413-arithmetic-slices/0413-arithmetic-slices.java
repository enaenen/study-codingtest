class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int total = 0;
        int key = Integer.MIN_VALUE;
        int count = Integer.MIN_VALUE;

        for (int i = 1; i < nums.length; i++){
            int diff = nums[i] - nums[i - 1];
            if (key != diff){
                key = diff;
                count = 0;
            } else {
                count++;
            }
            if (count >= 1){ 
                total += count;
            }
        }
        return total;
    }
}