import java.math.*;
class Solution {
    public String gcdOfStrings(String str1, String str2) {
        if (!(str1 + str2).equals(str2 + str1)) return "";
        return str1.substring(0, gcd_mod(str1.length(), str2.length()));

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