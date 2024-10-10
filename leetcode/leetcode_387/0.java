class Solution {
    public int firstUniqChar(String s) {
        int[] count = new int[26];
        Arrays.fill(count, 0);
        
        for(char c:s.toCharArray()) count[toIndex(c)]++;
        
          for(int i = 0; i < s.length(); i++) {
                    if (count[toIndex(s.charAt(i))] == 1) return i;
          }
        
        
        
        return -1;
        
    }
    
    private int toIndex(char c) {
        return c - 'a';
    }
    
}