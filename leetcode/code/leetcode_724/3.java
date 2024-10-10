class Solution {
    public int pivotIndex(int[] nums) {
        int sum=0;
        int len=nums.length;
        int left_value=0;
        for(int i=0;i<len;i++)
            sum+=nums[i];
        for(int j=0;j<len;j++)
        {
            sum-=nums[j];
                
                if(left_value==sum)
                    return j;
            
            left_value+=nums[j];
        }
        return -1;
    }
}