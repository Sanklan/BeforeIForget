class Solution {
    public int lengthOfLongestSubstring(String s) {
        int length = s.length();
        if (length < 2) return length; 
       
        int left = 0;
        int right = 1;
        int prev;
        int maxSize = 1;
        int[] map = new int[256];
        char[] str = s.toCharArray();
        Arrays.fill(map, -1);
        map[(int)str[left]] = left;
        while(right < length) {
            if (map[(int)str[right]] != -1) {
                prev = left;
                left = map[(int)str[right]] + 1;
                while(prev < left) map[str[prev++]] = -1;
            }
            //System.out.println(left + " " + right);
            map[(int)str[right]] = right;
            maxSize = Math.max(maxSize, right - left + 1);
            right++;
        }
        return maxSize;


    }
}