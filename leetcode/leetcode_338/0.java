class Solution {
    public int[] countBits(int n) {
        int[] ans = new int[n+1];
        ans[0] = 0;
        if (n == 0) return ans;
        ans[1] = 1;
        if (n == 1) return ans;
        // 2 to power 1
        int power = 2;
        
        for(int i = 2; i <= n; i++) {
            if ( i == power) power *= 2;            
            int cur_power = power/2;
            int diff = i - cur_power;
            ans[i] = 1 + ans[diff];
        }
        
        return ans;
        
        
    }
}