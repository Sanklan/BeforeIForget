class Solution {
    public String minWindow(String s, String t) {
        if (t.length() > s.length() || t.length() == 0 ) return "";
        //if (t.length() == s.length()) return (s.equals(t)) ? t : "";
        
        HashMap<Character, Integer> tCount = new HashMap<Character, Integer>();
        for(Character c: t.toCharArray()) {
            tCount.put(c, tCount.getOrDefault(c, 0) + 1);
        }
        
        HashMap<Character, Integer> currentCount = new HashMap<Character, Integer>();
        //Arrays.fill(currentCount, 0);
        
        int max = 0;
        String maxString = "";
        int start = 0;
        int end = 0;
        
        while(end < s.length() && start <= end) {
            Character c = s.charAt(end);
            currentCount.put(c, currentCount.getOrDefault(c, 0) + 1);
            if (end - start >= t.length() - 1) {
                    while(isMatch(tCount, currentCount) & start <= end) {
                        if ( max > end - start || max == 0) {
                            max = end - start;
                            maxString = s.substring(start, end + 1);
                        }
                        
                        currentCount.put(s.charAt(start), 
                                         currentCount.getOrDefault(s.charAt(start), 0) - 1);
                        start++;
                    }
            }
            end++;
        }
        return maxString;
    }
    
    private boolean isMatch(HashMap<Character, Integer> tCount, HashMap<Character, Integer> count) {
        for(Character key:tCount.keySet()) {
            if (count.getOrDefault(key, 0) < tCount.get(key)) return false;
        }
        return true;
    }
    
    private int index(Character c) {
        return (int)(Character.toLowerCase(c) - 'a');
    }
}