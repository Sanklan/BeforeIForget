public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {        
        int result = 0;
        int i = 0;
        while( i < 32) {
            int end = n & 1;
             n = n >> 1;
            result = result << 1;
            result = result | end;
            i++;
        }
        
        return result;
    }
    
}