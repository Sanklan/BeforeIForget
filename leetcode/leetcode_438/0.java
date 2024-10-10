class Solution {
    public List<Integer> findAnagrams(String s, String p) {


        int index = p.length();
        int pLen = p.length();
        int len = s.length();
        
        List<Integer> result = new ArrayList<Integer>();
        if (pLen <= len) {        
        int[] pCount = count(p);
        int[] current = count(s.substring(0, p.length()));

        
        while(index <= len) {
            if (matchFreq(pCount, current)) result.add(index - pLen);
            if (index >= len) break;
            current[charToIndex(s.charAt(index))]++;
            current[charToIndex(s.charAt(index - pLen))]--;
            index++;
        }}
        return result;
    }

    int charToIndex(char c) {
        return (int)(c - 'a');
    }

    int[] count(String s) {
        int[] c = new int[26];
        for(char ch:s.toCharArray()) c[charToIndex(ch)]++;
        return c;
    }

    boolean matchFreq(int[] one, int[] two) {
        for(int i = 0; i < 26; i++)
            if (one[i] != two[i]) return false;

        return true;
    }
}