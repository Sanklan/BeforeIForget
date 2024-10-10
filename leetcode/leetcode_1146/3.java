import java.math.*;
class Solution {
    public String gcdOfStrings(String str1, String str2) {
        BigInteger m = new BigInteger("" + str1.length());
        BigInteger n = new BigInteger("" + str2.length());
        if (!(str1 + str2).equals(str2 + str1)) return "";
        int gcd = m.gcd(n).intValue();
        return str1.substring(0, gcd);

    }
}