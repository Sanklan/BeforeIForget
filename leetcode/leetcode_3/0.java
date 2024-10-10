class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length()  == 0) return 0;
        if (s.length() == 1) return 1;

        HashMap<Character, Integer> index = new HashMap<Character, Integer>();
        HashSet<Character> set = new HashSet<Character>();

        int len = s.length();
        int start = 0;
        set.add(s.charAt(0));
        index.put(s.charAt(0), 0);
        int max = 1;
        char c;
        
        for(int i = 1; i < len; i++) {
            c = s.charAt(i);
            if (set.contains(c)) {
                int lst = index.get(c);
                while(start <= lst) {
                    index.remove(c);
                    set.remove(c);
                    start++;
                }
                //start = index.get(c) + 1;

            } // else {                
                max = Math.max(max, i - start + 1);            
         //   }
            set.add(c);
            index.put(c, i);
           
        }

        return max;
    }
}