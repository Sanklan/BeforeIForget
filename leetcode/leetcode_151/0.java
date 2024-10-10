class Solution {
    public String reverseWords(String s) {
        String[] words = s.trim().split(" ");
        StringBuilder strblr = new StringBuilder();
        for(int i = words.length - 1; i >= 0; i--) {
            if (!words[i].isEmpty()) {
                strblr.append(words[i]);
                if ( i > 0) strblr.append(" ");
            }
        }

        return strblr.toString();
    }
}