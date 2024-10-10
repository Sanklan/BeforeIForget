public class Solution {
    public int[] TwoSum(int[] nums, int target) {
        int[] result = new int[2];
        int r = 0;
        int len = nums.Length;
        int temp = -1;
        for(int i = 0; i < len; i++)
        {
            if((nums[i] <= target && target >= 0) || (target < 0 && nums[i] >= target))
            {
                temp = target - nums[i];
                result[0] = i;
                for(int j = i+1; j < len; j++)
                {
                    if(nums[j] == temp)
                    {
                        result[1] = j;
                        return result;
                    }
                }
            }
            
            
        }
        
        return result;
        
    }
}