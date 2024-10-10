class Solution {
    public int[] runningSum(int[] nums) {
        int[] runningSumArray = new int[nums.length];
        for(int i = 0; i < nums.length; i++) 
        {
         if ( i == 0)  runningSumArray[i] = nums[i];
         else runningSumArray[i] = runningSumArray[i - 1] + nums[i];
        }
        return runningSumArray;
    }
}