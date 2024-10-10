class Solution {
    public int search(int[] nums, int target) {
        // find k 
        int k = K(nums);
        
        
        // +k % n
        int n = nums.length;
        int left = 0;
        int right = nums.length;
        
        while(left <= right) {
            int mid = left + (right - left)/2;
            int modmid = (mid + k) % n;
            if (left == right) {
                if (nums[modmid] == target) return modmid;
                else break;
            }
            
            if (nums[modmid] == target) return modmid;
            else if (nums[modmid] < target) {
                left = mid + 1;
            } 
            else {
                right = mid - 1;
            }
        }
        return -1;
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