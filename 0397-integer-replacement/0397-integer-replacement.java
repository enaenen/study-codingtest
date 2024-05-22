class Solution {
    public int integerReplacement(int n) {
        return divider(0, n);
        
    }
    private int divider(int count, int n){
        int result = Integer.MAX_VALUE;
        if (n == Integer.MAX_VALUE) return 32;
        
        if (n == 1)
            return count;
            
        if (n % 2 == 0)
            result = Math.min(result, divider(count + 1, n / 2));
        else{
           result = Math.min(result, divider(count + 1, n + 1));
           result = Math.min(result, divider(count + 1, n - 1));
        }
        return result;
    }
}