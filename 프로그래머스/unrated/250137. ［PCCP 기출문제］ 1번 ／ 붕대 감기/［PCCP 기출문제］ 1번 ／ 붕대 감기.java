class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int currentHealth = health;
        int currentTime = 0;
        for (int i = 0; i < attacks.length; i++){
            int gap = attacks[i][0] - currentTime - 1;
            if (gap > 0){
                //heal
                currentHealth += (gap) * bandage[1];
                if (bandage[0] <= gap)
                    currentHealth += bandage[2] * gap / bandage[0];
                if (currentHealth > health)
                    currentHealth = health;
            }
            currentHealth -= attacks[i][1];
            currentTime = attacks[i][0];
            if (currentHealth <= 0)
                return -1;
        }
        return currentHealth;
    }
}