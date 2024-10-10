class Solution {
    public int findMin(int[] nums) {
        return nums[K(nums)];
    }

    private int K(int[] nums) 
    {
        if ( nums.length < 2) return 0;
        if (nums[0] < nums[nums.length - 1]) return 0;
        
        int left = 0;
        int right = nums.length - 1;
        
        while (left <= right) {
            int mid = left + (right - left)/2;
            if (nums[mid] > nums[mid + 1]) 
            {
                return mid + 1;
            }
            if (nums[mid - 1] > nums[mid]) 
            {
                return mid;
            }
            if (nums[left] < nums[mid]) {
                left = mid + 1;
                continue;
            }
            if (nums[mid] < nums[right]) {
                right = mid - 1;
                continue;
            }
            
        }
        return 0;        
    }
}