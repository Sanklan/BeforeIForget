class Solution {
    public boolean isPowerOfFour(int n) {
        if (n == 1) return true;
        if (n < 4) return false;
        int last;
        while(n > 4) {
            last = n % 10;
            if ((last == 4 || last == 6) && n % 4 == 0) 
                n /= 4;
            else return false;
        } 

        return n == 4;

    }

    int lastDigit(int n) {
        while(n >= 10) n /= 10;
        return n;
    }
}