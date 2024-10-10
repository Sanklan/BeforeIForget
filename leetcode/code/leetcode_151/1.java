class Solution {
    public String reverseWords(String s) {
        s = s.trim();
        String[] words = s.split(" ");
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