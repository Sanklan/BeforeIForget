class Solution {
    public boolean isPalindrome(int x) {
        
        int reverse_num=0;
        int num=x;
        
        
        if (x<0)
            return false;
        
        
        else {
            
      while(x!=0)
      {
          
       int rem =0;  
        
          rem= x%10;
          x =x/10;
          reverse_num= reverse_num*10 +rem;
      }
    return reverse_num==num; 
    }
    }
}
