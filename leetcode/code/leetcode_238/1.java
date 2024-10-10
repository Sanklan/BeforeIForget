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
        if (haszero > 1) return answer;

        for(int i = 0; i < nums.length; i++) {
            if (haszero == 1) 
            {
                 if (nums[i] == 0) answer[i] = totalProduct;
            } else {
                answer[i] = totalProduct / nums[i];
             }
        }
        
        return answer;
    }
}