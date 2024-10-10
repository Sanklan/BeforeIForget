class Solution {
    public int reverse(int x) {
        String d = "" + x;
        StringBuilder y = new StringBuilder();
        int n = d.length() - 1;
        int i = 0;
        if (x < 0) {
            i = 1;
            y.append("-");
        }
        while(n >= i) {
            y.append(d.charAt(n));
            n--;
        }
        
        try {
            int ret = Integer.parseInt(y.toString());
            return ret;
        }catch(Exception ex) {
            return 0;
        }
    }
}