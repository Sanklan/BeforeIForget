import java.math.*;
class Solution {
    public String gcdOfStrings(String str1, String str2) {
        int m = str1.length();
        int n = str2.length();
        if (!(str1 + str2).equals(str2 + str1)) return "";
        return str1.substring(0, gcd_mod(m, n));

    }

    private int gcd_mod(int x, int y) {
        if (x == 0) return y;
        return gcd_mod(y % x, x);
    }
    private int gcd(int x, int y) {
        if (x == 0) return y;
        while(y != 0) {
            if (x > y) x = x - y;
            else y = y - x;
        }
        return x;
    }
}