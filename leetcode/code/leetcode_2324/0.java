class Solution {
    public int triangularSum(int[] nums) {
        for(int len = nums.length; len >= 2; len--)
            recur(nums, len);
        return nums[0];
    }

    private void recur(int[] nums, int len) {
        if (len < 2) return;
        for(int i = 1; i < len; i++) {
            nums[i - 1] = (nums[i] + nums[i - 1]) % 10;
        }
    }
}