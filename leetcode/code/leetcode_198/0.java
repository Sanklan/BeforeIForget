class Solution {
    public int rob(int[] nums) {
        // f(n) = max ( f(n + 1),nums[n] +  f(n + 2));

        int dp[]  = new int[nums.length];
        dp[nums.length - 1] = nums[nums.length - 1];
        for(int i = nums.length -2; i >= 0; i--) {
            int pick = nums[i] + ((i + 2 < nums.length) ? dp[i + 2] : 0);
            dp[i] = Math.max(dp[i + 1], pick);
        }

        return dp[0];
        //memo.clear();
        //return rob(nums, 0);
    }
    HashMap<Integer, Integer> memo = new HashMap<Integer, Integer>();
    private int rob(int[] nums, int index) {
        if (index >= nums.length) return 0;
        if (memo.containsKey(index)) return memo.get(index);
        
        int pick = nums[index] + rob(nums, index + 2);
        int leave = rob(nums, index + 1);

        int max = Math.max(pick, leave);
        memo.put(index, max);
        return max;
    }
}