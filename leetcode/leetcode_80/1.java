class Solution {
    public int removeDuplicates(int[] nums) {
        int count = 0;
            for (final int num : nums){
                //System.out.println(num);
                if(count < 2 || num > nums[count-2] )
                {
                    nums[count++] = num;
                }
            }
    return count; 
    }
}