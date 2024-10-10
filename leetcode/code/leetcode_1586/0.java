class Solution {
    public int longestSubarray(int[] nums) {
        int left = 0, right = 0, zero = -1;
        int max = 0;
        while (right < nums.length) {
            if (nums[right] == 0) {
                if (zero >= 0) left = zero + 1;
                zero = right;
            }
            max = Math.max(right - left, max);
            right++;
        }
        return max;
    }
}