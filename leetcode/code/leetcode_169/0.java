class Solution {
    public int majorityElement(int[] nums) {
        int candidate = nums[0];
        int count = 1;

        for(int i = 1; i < nums.length; i++) {
            if (count > 0) {
                if (nums[i] == candidate) {
                    count++;
                } else {
                    count--;
                }
            } else {
                //count == 0\
                candidate = nums[i];
                count++;
            }
        }

        return candidate;
    }
}