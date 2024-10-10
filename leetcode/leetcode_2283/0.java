import java.util.Collections;

class Solution {
    public int[] sortEvenOdd(int[] nums) {
        // 9 = 0 1 2 3 4 5 6 7 8 
        // 0 2 4 6 8 
        // 1 3 5 7
        
        // 8 = 0 1 2 3 4 5 6 7
        // 0 2 4 6
        // 1 3 5 7
        int n = nums.length;
        
        int[] evens = new int[n/2 + ((n % 2 == 0) ? 0 : 1)];
        int[] odds =  new int[n/2];
        
        for (int i = 0; i < n; i++) {
            if ( i % 2 == 0) {
                evens[i/2] = nums[i];
            } else {
                odds[i/2] = nums[i];
            }
        }
        
        Arrays.sort(odds);
        Arrays.sort(evens);
        
        int l = n/2 - 1;
        
        for (int i = 0; i < n; i++) {
             if ( i % 2 == 0) {
                nums[i] = evens[i/2] ;
            } else {
                nums[i] = odds[l - i/2];
            }
        }
        
        return nums;
    }
}