class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double sum = 0;
        double avg = Integer.MIN_VALUE;
        int right = 0;
        int left = 0;
        for(; right < k && right < nums.length; right++) sum += nums[right];
        avg = sum / k;
        for(; right < nums.length; right++) {
            sum = sum - nums[left++] + nums[right];
            avg = Math.max(avg, sum/k);
        }

        return avg;
    }
}