class Solution {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int mid = -1;
        int index = -1;
        while( left < right ) 
        {
         //System.out.println(left + " " + right);
         mid = (left + right) / 2;
         
         if (right - left == 1)
         {
             if (nums[left] > nums[right]) {
                 index = left;
                 break;
             }
         }
         if (nums[mid] < nums[left]) {
             right = mid;
             continue;
         } 
         if (nums[mid] > nums[right]) {
             left = mid;
            continue;
         } 
        if (nums[left] < nums[right]) break;
        }
        
        return nums[index + 1];
        
    }
}