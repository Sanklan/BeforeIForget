class Solution {
    public int climbStairs(int n) {
        int[] memo = new int[n + 1];
        for(int i = 3; i <= n; i++) memo[i] = -1;
        return climb(n, memo);
        
    }
    
    private int climb(int n, int[] memo) {
        if (n < 2) return 1;
        if (n == 2) return 2;
        if (memo[n] > 0) return memo[n];        
        
        int ways = climb(n - 1, memo) + climb(n - 2, memo);
        memo[n] =  ways;
        
        return ways;
    }
}