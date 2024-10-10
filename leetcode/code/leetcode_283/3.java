class Solution {
    public void moveZeroes(int[] nums) {
        for(int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] == 0) {
                int j = i;
                for(;j < nums.length - 1 && nums[j + 1] != 0; j++) {
                    nums[j] = nums[j + 1];
                }
                if (j < nums.length) nums[j] = 0;
            }
        }
    }
}