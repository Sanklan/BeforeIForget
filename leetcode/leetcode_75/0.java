class Solution {
    public void sortColors(int[] nums) {
        int zero = 0;
        int one = 0;
        int two = 0;
        for(int num: nums) {
            if (num == 0) zero++;
            if (num == 1) one++;
            if (num == 2) two++;
        }
        
        int i = 0;
        while( i < zero) {
            nums[i] = 0;
            i++;
        }
        while( i < (zero + one)) {
            nums[i] = 1;
            i++;
        }
        while( i < nums.length) {
            nums[i] = 2;
            i++;
        }
                
    }
}