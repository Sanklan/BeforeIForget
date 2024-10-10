class Solution {
    public int[] productExceptSelf(int[] nums) {
        int totalProduct = 1;
        int[] answer = new int[nums.length];
        int haszero = 0;
        for(int i = 0; i < nums.length; i++)
        {
            if (nums[i] == 0)
            {
                haszero++;
                continue;
            }
            totalProduct *= nums[i];
        }
        for(int i = 0; i < nums.length; i++) {
            if (haszero == 0) answer[i] = totalProduct / nums[i];
            else  if (haszero == 1) 
             {
                 if (nums[i] == 0) answer[i] = totalProduct;
                 else answer[i] = 0;
             }
            else answer[i] = 0;
        }
        
        return answer;
        
    }
}