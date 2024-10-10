class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double sum = 0;
        int right = 0;
        int left = 0;
        for(; right < k && right < nums.length; right++) sum += nums[right];
        double max = sum;
        for(; right < nums.length; right++, left++) {
            sum = sum - nums[left] + nums[right];
            max = Math.max(max, sum);
        }
        return max/k;
    }
}