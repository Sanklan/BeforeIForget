class Solution {
    public int[] nextGreaterElements(int[] nums) {
        
        int currentStartIndex = 0;
        int currentEndIndex = 1;
       // int currentMin = nums[currentStartIndex];
        int[] res = new int[nums.length];
        if(nums.length == 1) {
            res[0] = -1;
            return res;
        }
        while(currentStartIndex < nums.length) {
            if(nums[currentEndIndex % nums.length] > nums[currentStartIndex] && currentEndIndex % nums.length != currentStartIndex) {
                res[currentStartIndex++] = nums[currentEndIndex % nums.length];
                currentEndIndex = currentStartIndex + 1;
            }
            else if(currentEndIndex % nums.length == currentStartIndex) {
                res[currentStartIndex++] = -1;
                currentEndIndex = currentStartIndex + 1;
            }
            else
            currentEndIndex++;
        }
        
        return res;
    }
}