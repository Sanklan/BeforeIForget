class NumArray {

    int nums[];
    int sum[];
    public NumArray(int[] nums) {
        this.nums = nums;
        this.sum = Arrays.copyOf(nums, nums.length);
        for(int i = 1; i < nums.length; i++) sum[i] += sum[i - 1];    
    }
    
    public int sumRange(int left, int right) {
       // left = Math.max(left, 0);
        //right = Math.min(nums.length - 1, right);
        return nums[left] + sum[right] - sum[left];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */