class Solution {
    public int firstMissingPositive(int[] nums) {
       
    
        
        int min = Integer.MAX_VALUE;
        int max = -1;
       // int sum = 0; // 7 8 9 11 12  = 47
      //  int missingSum = 0; // 7 8 9 10 11 12 = 57
        
        for(int n:nums) {
       //     sum += n;
            min = Math.min(min, n);
            max = Math.max(max, n);
        }
        
        if (min > 1 || max <= 0) return 1;

        // min < 1
        // min == 1
         for(int n:nums) {
             if (min <= 0 && n > 0) {
                 min = n;
             } else if (n > 0){
                 min = Math.min(min, n);
             }
             
             
         }
         //System.out.println(min);
         if (min != 1) return 1;

         int n = nums.length;
         for(int i = 0; i < nums.length; i++) {
             if (nums[i] <= 0 || nums[i] > nums.length) {
                 nums[i] = 1;
             }
         }
        //Arrays.stream(nums).forEach(System.out::println);
         for(int i = 0; i < nums.length; i++) {
             nums[(nums[i] - 1) % n] += n;
         }
       // Arrays.stream(nums).forEach(System.out::println);
        for(int i = 0; i < nums.length; i++) {
            if (nums[i] <= n) return i + 1;
        }
       // Arrays.stream(nums).forEach(System.out::println);
        return n + 1;
         /*
         if (min > 1) return 1;
         int max_s = max;
         for(int n:nums) {
             if (n > min && n < max_s) max_s = n;
         }
       
        for(int i = min + 1; i < max; i++) {
            if ( i > 0) return i;
        }*/
        
       // return max + 1;
    }
}