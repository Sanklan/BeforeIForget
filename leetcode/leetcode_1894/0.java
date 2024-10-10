class Solution {
    public String mergeAlternately(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int i = 0;
        int j = 0;
        boolean first = true;
        StringBuilder builder = new StringBuilder();
        while(i < m || j < n) {
            if (i >= m) builder.append(word2.charAt(j++));
            else if ( j >= n) builder.append(word1.charAt(i++));
            else if (first) builder.append(word1.charAt(i++));
            else builder.append(word2.charAt(j++));
            first = !first;
        }

        return builder.toString();
    }
}