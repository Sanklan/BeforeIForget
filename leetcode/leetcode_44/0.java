class Solution {
    public boolean isMatch(String s, String p) {
        return match(s, 0, p, 0, new HashMap<String, Boolean>());
    }
    
    private boolean match(String s, int i, String p, int j, HashMap<String, Boolean> memo) {
        if (s.length() == i) {
            while(j < p.length()) 
                if (p.charAt(j) == '*') j++;
                else break;            
        }
        if (s.length() == i && p.length() == j) return true;
        if (s.length() == i || p.length() == j) return false;
        if (memo.containsKey(i + "_" + j)) return memo.get(i + "_" + j);
        boolean ret = false;
        if (p.charAt(j) == '?') {
            ret = match(s, i + 1, p, j + 1, memo);
        } else if (p.charAt(j) == '*') {
            ret = match(s, i + 1, p, j + 1, memo) 
                || match(s, i + 1, p, j, memo)
                || match(s, i, p, j + 1, memo);
        } else {
            if (p.charAt(j) != s.charAt(i)) ret = false;
            else ret = match(s, i + 1, p, j + 1, memo);
        }
        memo.put(i + "_" + j, ret);
        return ret;
    }
}