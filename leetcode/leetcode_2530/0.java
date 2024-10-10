class Solution {
    public int minimizeArrayValue(int[] nums) {
         long sum = 0, max = 0;
		for (int i = 0; i < nums.length; i++) {
			max = Math.max(max, ((sum += nums[i]) + i) / (i + 1));
		}
		return (int) max;
        
        
        /*int max = nums[0]; 
        int sum = 0;
        int index = 0;
        for(int num:nums) {
            sum += num;
            max =(int) Math.max(max, Math.ceil((sum + index) / (index + 1) ));
            index++;
        }
        return max;*/
    }
}