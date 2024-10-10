class Solution {
    public String minRemoveToMakeValid(String s) {
        int open = 0;
        int close = 0;
        int remove = 0;
        StringBuilder strbuilder = new StringBuilder();
        for(char c:s.toCharArray()) {
            if (c == ')' && close == open) continue;
            strbuilder.append(c);
            if (c == '(' ) open++;
            if (c == ')') close++;
        }
        int len = strbuilder.length() - 1;
        while(open > close && len >= 0) {
            if (strbuilder.charAt(len) == '(') {
                strbuilder.deleteCharAt(len);
                open--;
            }
            len--;
        }
        return strbuilder.toString();
    }
}