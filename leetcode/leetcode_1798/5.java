class Solution {
    public int maxOperations(int[] nums, int k) {
        Arrays.sort(nums);
        int i = 0, j = nums.length - 1;
        int count = 0;
        while( i < j) {
            if (k - nums[i] == nums[j]) {
                count++;
                i++;
                j--;
            } else if (k - nums[i] > nums[j]) {
                i++;
            }  else j--;
        }

        return count;
    }
}