class Solution {
    public int lengthOfLastWord(String s) {
        s = s.strip();
        int length = s.length() - 1;
        for(int i = length; i >= 0; i--) {
            if (s.charAt(i) == ' ')
                return length - i;
        }
        return length + 1;
        // String[] words = s.strip().split(" ");
        // return words[words.length - 1].length();
    }
}