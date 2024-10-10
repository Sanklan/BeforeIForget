class Solution {
    public int titleToNumber(String columnTitle) {
        int n = columnTitle.length();
        int sum = 0;
        for(int i = 1; i <= n; i++) {
            sum += toInt(columnTitle.charAt(n - i)) * Math.pow( 26 , i - 1);
        }

        return sum;
    }

    private int toInt(char c) {
        return (int)(c - 'A') + 1;
    }
}