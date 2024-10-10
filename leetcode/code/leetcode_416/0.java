class Solution {
    public boolean canPartition(int[] nums) {
        // f(i, target) = f(i + 1, target - nums[i]) || f(i + 1, target)
        int sum = Arrays.stream(nums).sum();
        if (sum % 2 == 1) return false;
        sum = sum/2;
        boolean dp[][] = new boolean [nums.length + 1][sum + 1]; 
        //for zero sum .. always true
        for(int i = 0; i <= nums.length; i++) dp[i][0] = true;
        // for zero nums.. always false
        for(int i = 1; i <= sum; i++) dp[0][i] = false;

        for(int i = 1; i <= nums.length; i++) {
            for (int s = 1; s <= sum; s++) {
                //don't pick i - 1, s
                //pick i - 1, s - nums[i - 1]
                dp[i][s] = dp[i - 1][s];
                if (!dp[i][s] && s - nums[i - 1] >= 0) {
                    dp[i][s] = dp[i - 1][s - nums[i - 1]];
                }
            }
        }
        
        return dp[nums.length][sum];
    }
}