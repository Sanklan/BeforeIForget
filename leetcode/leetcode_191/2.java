public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
       
        char[] c = Integer.toBinaryString(n).toCharArray();
        
       int count = 0;
      /*  while(n > 0) {
            if (n % 2 == 1) count++;
            System.out.println(n);
            n = n >> 1;
        }*/
        
       // count = 0;
        for (char ch:c) if (ch == '1') count++;
        
        return count;
    }
}