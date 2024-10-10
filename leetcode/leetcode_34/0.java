class Solution {
    public int[] searchRange(int[] nums, int target) {
        int index = Arrays.binarySearch(nums, target);
        if (index < 0) return new int[] {-1, -1};

        int[] ret = new int[] {index, index};

        while(ret[0] > 0 && nums[ret[0]] == nums[ret[0] - 1]) ret[0]-=1;
        while(ret[1] < nums.length - 1 && nums[ret[1]] == nums[ret[1] + 1]) ret[1]+=1;

        return ret;
    }
}