class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length < 3) return nums.length;
        int index = 0;
        int cursor = 1;
        int count = 1;
        while(cursor < nums.length) {
            if (nums[cursor] > nums[index]) {
                index++;
                nums[index] = nums[cursor];
                count = 1;
            } else if (nums[cursor] == nums[index] && count < 2) {
                index++;
                nums[index] = nums[cursor]; 
                count = 2;
            }
            cursor++;
        }
        return index + 1;
    }
}