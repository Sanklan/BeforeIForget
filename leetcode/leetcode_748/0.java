class Solution{
    public int dominantIndex(int[] nums) {
        int value=0;
      int index=0;
        int hig_value=nums[0];
        for(int i=1;i<nums.length;i++)
        {
           if(hig_value<nums[i]) 
           {
             hig_value=nums[i];
             index=i;
           }
           
        }
      for(int k=0;k<nums.length;k++)
      {
          if(nums[k]!=hig_value)
          {
          int new_value=nums[k]*2;
         
          if(new_value>hig_value)
           return -1;
          
          else
          value =k;
        
          
      }
      }
      
         return index;
        
    }
}