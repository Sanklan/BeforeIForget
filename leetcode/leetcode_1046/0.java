class Solution {
    //unable to solve
    public int longestOnes(int[] nums, int k) {
        int start = 0;
        int end = 0;
        int max = 0;
        int count = 0;
        int zeros = 0;
        while(end < nums.length) {
            if (nums[end] == 1) {
                count++;
                end++;
                max = Math.max(max, count);                
            }
            else if (zeros < k && nums[end] == 0){
                zeros++;
                count++;
                end++;
                max = Math.max(max, count);
            } else {
                end++;
                zeros++;
                count++;
                //zeros >= k && nums[end] = 0
                while (zeros > k && start <= end) {
                    if (nums[start] == 0) zeros--;
                        start++;
                        count--;
                }
                max = Math.max(max, count);
            }
            
          //  System.out.println(toString(nums, start, (end - 1)) + " : " + max + " zeros:" + zeros);
            
        }
        
        return max;
    }
    
    private String toString(int[] nums, int i, int j) {
        StringBuilder sb = new StringBuilder();
        for(int k = i; k <= j; k++) sb.append(nums[k] + ", ");
        return sb.toString();
    }
}