class Solution {
    //private HashMap<String, String> memory = new HashMap<String, String>();
    public String longestPalindrome(String s) {
        if (s.length() < 2) return s;
        if (s.length() == 2) {
            if (s.charAt(0) == s.charAt(1)) return s;
            else return s.substring(0, 1);
        }
        
        int longestPallindromLength = 1;
        String longest = s.charAt(0) + "";
        int n = s.length();
        for(int i = 0; i < n - 1; i++) {
            if (i > 0)
              if (s.charAt(i - 1) == s.charAt(i + 1)) {
                String pallin = getPallindrome(s, i - 1, i + 1, 2);
                int currentLength = pallin.length();
                if (longestPallindromLength < currentLength) {
                    longestPallindromLength = currentLength;
                    longest = pallin;
                }
            } 
          /*  if (s.charAt(i - 1) == s.charAt(i)) {
                String pallin = getPallindrome(s, i - 1, i, 1);
                int currentLength = pallin.length();
                if (longestPallindromLength < currentLength) {
                    longestPallindromLength = currentLength;
                    longest = pallin;
                }
            } */
            if (s.charAt(i) == s.charAt(i+1)) {
                String pallin = getPallindrome(s, i, i + 1, 1);
                int currentLength = pallin.length();
                if (longestPallindromLength < currentLength) {
                    longestPallindromLength = currentLength;
                    longest = pallin;
                }
            }
        }
        
        return longest;
    }
    
    
    private String getPallindrome(String s, int left, int right, int currentLength) {
        int n = s.length();
        String key = left + "_" + right;
      //  if (memory.containsKey(key)) return memory.get(key);
        while(left >= 0 && right < n) {
                if (s.charAt(left) != s.charAt(right)) break;
                currentLength +=2;
                left--;
                right++;
        }
        System.out.println(left + " " + right);
        return s.substring(left + 1, right);
    }
}