class Solution {
    public int removeElement(int[] nums, int val) {
        int last = 0;
        for (int i = 0; i < nums.length - last; i++) {
            if (nums[i] == val) {
                last++;
                Solution.swap(nums, i, nums.length - last);
                i--;
            }
        }

        return nums.length - last;
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}