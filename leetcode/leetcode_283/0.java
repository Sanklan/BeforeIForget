class Solution {
    public void moveZeroes(int[] nums) {
        int index = 0;
        for(int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                continue;
            } else if (nums[i] != 0 && index < i) {
                nums[index] = nums[i];
            }
            index++;
        }
        while(index < nums.length) nums[index++] = 0;
    }
}