class Solution {
    private int[] original;
    private int[] shuffled;

    public Solution(int[] nums) {
        original = nums.clone();
        shuffled = nums.clone();
    }
    
    public int[] reset() {
        return original.clone();
    }
    
    public int[] shuffle() {
        ThreadLocalRandom random = ThreadLocalRandom.current();
        int randIdx = random.nextInt(shuffled.length);
        int nextIdx = randIdx - 1;
        if (randIdx == 0) nextIdx = shuffled.length -1;

        int tmp = shuffled[randIdx];
        shuffled[randIdx] = shuffled[nextIdx];
        shuffled[nextIdx] = tmp;
        return shuffled; 
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */