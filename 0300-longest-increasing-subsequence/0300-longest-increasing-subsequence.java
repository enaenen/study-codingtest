class Solution {
    public int lengthOfLIS(int[] nums) {
        List<Integer> subList = new ArrayList<Integer>();
        subList.add(nums[0]);
        for (int i = 1; i < nums.length; i++){
            if (nums[i] > subList.get(subList.size() - 1)) subList.add(nums[i]);
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
