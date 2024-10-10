class Solution {
    public int maxProduct(int[] nums) {
        int max = nums[0];
        int currentProduct = 1;       
        int left = 0;
        int right = 0;
        while (right < nums.length && left < nums.length)
        {   
            if (nums[right] == 0) {
                max = rightMax(left, right - 1, currentProduct, nums, max);
                max = leftMax(left, right - 1, currentProduct, nums, max);
                max = max > 0 ? max : 0;
                right++;
                left = right;
                currentProduct = 1;
                continue;
            }
            currentProduct *= nums[right++];
            max = (max > currentProduct) ? max : currentProduct;
        }
        max = rightMax(left, nums.length - 1, currentProduct, nums, max);
        max = leftMax(left, nums.length - 1, currentProduct, nums, max);
        return max;
    }
    
    private int rightMax(int left, int right, int currentProduct, int[] nums, int max) {
        if (left < right && currentProduct < 0 && left < nums.length) {
            while(currentProduct < 0) currentProduct /= nums[left++];            
            max = (max > currentProduct) ? max : currentProduct;
        }        
        return max;
    }
    
    private int leftMax(int left, int right, int currentProduct, int[] nums, int max) {
        if (left < right && currentProduct < 0 && right >= 0) {
            while(currentProduct < 0) currentProduct /= nums[right--];            
            max = (max > currentProduct) ? max : currentProduct;
        }
        return max;
    }
}