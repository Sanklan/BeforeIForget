class Solution {
    public String addBinary(String a, String b) {
        int carry = 0;
        int lena = a.length() - 1;
        int lenb = b.length() - 1;
        int t, k, l, p;
        StringBuilder str = new StringBuilder();
        for(; lena >= 0 &&  lenb >= 0; lena--, lenb--) {
            t = a.charAt(lena) == '0' ? 0 : 1;
            k = b.charAt(lenb) == '0' ? 0 : 1;
            p = carry;
            carry = t & carry;
            t = t ^ p;
            if (t == 0) t = k;
            else {
                t = k ^ t;
                carry = carry | k;
            }
            str.append(t);
            


        }

        while(lena >= 0) {
             t = a.charAt(lena--) == '0' ? 0 : 1;
            str.append(t ^ carry);
            carry = carry & t;
        }

        while(lenb >= 0) {
            t = b.charAt(lenb--) == '0' ? 0 : 1;
            str.append(t ^ carry);
            carry = carry & t;
        }
        if (carry == 1) str.append(carry);
        return str.reverse().toString();
    }

    
    
}