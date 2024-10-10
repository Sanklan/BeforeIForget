class Solution {
    public String reverseWords(String s) {
        s = s.trim();
        String[] split = s.split(" ");
        int length = split.length;
        StringBuilder sb = new StringBuilder();
        for (int i = length - 1; i >= 0; i--) {
            String t = split[i].trim();
            if (t.length() > 0) {
                sb.append(t);
                sb.append(" ");
            }
        }

        sb.	deleteCharAt(sb.length() - 1);
        return sb.toString();
    }
}