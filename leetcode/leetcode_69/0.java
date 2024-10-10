class Solution {
    public int mySqrt(int x) {
        if ( x < 2 ) return x;
        long max = x / 2;
        long min = 1;

        while(min < max) {
            long mid = (max + min) / 2;
            long midsq = mid * mid;
            /*if (midsq < 0) {
                max = mid / 2;
                continue;
            }*/
            if (mid == min) {
                long maxsq = max * max;
                if (maxsq <= x) return (int)max;
                else return (int)min;
            }
            
            //System.out.println(mid);
            if (midsq > x) max =  mid;
            else if (midsq < x) min = mid;
            else return (int)mid;
        }

        return (int)max;
    }
}