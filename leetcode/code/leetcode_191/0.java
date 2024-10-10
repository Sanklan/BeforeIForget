public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
       
        char[] c = Integer.toBinaryString(n).toCharArray();
        
       int count = 0;
        
      /*  if (n < 0) {
            n ^= Integer.MIN_VALUE;
            count++;
        }
        
        while(n > 0) {
            if (n % 2 == 1) count++;
            System.out.println(n);
            n = n >> 1;
        }*/
        
        for (char ch:c) if (ch == '1') count++;
        
        return count;
    }
}