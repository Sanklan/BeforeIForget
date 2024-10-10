class Solution {
    public String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs, new Comparator<String>() {
            public int compare(String s1, String s2) {
                return s1.length() - s2.length();
            }
        });
        
        int max = strs[0].length();
        String ret= strs[0];
        
        int current = -1;
        while(current < max - 1) {
            boolean match = true;
            for (String s:strs) {
                if (s.charAt(current + 1) != ret.charAt(current + 1)) {
                    if (current == -1) return "";
                    else return ret.substring(0, current + 1);
                }
            }
            current++;
        }
        return ret;
    } 
}