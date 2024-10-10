class Solution {
    public int lengthOfLongestSubstring(String s) {
        int length = s.length();
        if (length < 2) return length; 
        HashSet<Character> occurance = new HashSet<Character>();
        int left = 0;
        int right = 1;
        int maxSize = 1;
        occurance.add(s.charAt(left));
        while(right < length) {
            char c = s.charAt(right);
            if (occurance.contains(c)) {
                while(left < right) {
                    occurance.remove(s.charAt(left));
                    left++;
                    if (s.charAt(left - 1) == c) break;
                }
            }
            System.out.println(s.substring(left, right + 1));
            occurance.add(c);
            maxSize = Math.max(maxSize, right-left + 1);
            right++;
        }

        return maxSize;


    }
}