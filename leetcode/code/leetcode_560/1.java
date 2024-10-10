class Solution {
    public int subarraySum(int[] nums, int k) {
        int[] sum = new int[nums.length];
        sum[0] = nums[0];
        IntStream.range(1, nums.length).forEach( i -> sum[i] = sum[i-1] + nums[i]);
        int subArrayCount = 0;
        for (int i = 0; i < nums.length; i++) {
            if (sum[i] == k) subArrayCount++;
            for(int j = 0; j < i; j++)
                if (sum[i] - sum[j] == k) subArrayCount++;
        }
        return subArrayCount;
    }
}