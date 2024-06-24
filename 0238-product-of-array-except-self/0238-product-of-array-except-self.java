class Solution {
    public int[] productExceptSelf(int[] nums) {
        int left = 1;
        int n = nums.length;
        int[] result = new int[n];

        for (int i = 0; i < n; i++){
            result[i] = left;
            left *= nums[i];
        }
        int right = 1;
        for (int i = n-1; -1 < i; i--){
            result[i] *= right;
            right *= nums[i];
        }
        return result;
    }
}