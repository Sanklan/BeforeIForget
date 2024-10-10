class Solution {
    public int maxSubArray(int[] nums) {
        int sum = 0;
        int left = 0;
        int right = 0;
        int max = nums[0];
        while (left < nums.length && right < nums.length ) {            
            sum = sum + nums[right]; 
            if (sum > max) max = sum;
            if (sum < 0)
            {
                right++;
                left = right;
                sum = 0;
                continue;
            }            
            right++;
           // System.out.println(left+" "+ right +" "+sum + " " + max);
        }
        
        return max;
    }
}