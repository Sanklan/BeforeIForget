class Solution {
    public String convert(String s, int numRows) {
        //n = 3
        //1, 5, 9, 13    // 0, 4 , 8, 12
        //2, 4, 6, 8, 10 // 1 ,3, 5, 7
        //3, 7, 11       // 2, 6, 10
        
        //n = 4
        // 0 6 12
        // 1 5 7 11 13 // 4 - 2 * 1
        // 2 4 8 10 // 4 - 0*2
        // 3 9
        
        // series for last and first 0 + d(2n - 2) or (n - 1) + d(2n - 2)
        //
        
        /*
        0     8
        1   7 9  2 series
        2  6  10 4 series 
        3 5   11 6 series
        4     12  
        
        */
        
        int series = 0;
        int subseries = 0;
        StringBuilder sb = new StringBuilder();
        int n = s.length();
        int incr = (numRows > 2) ? (2*numRows - 2) : numRows;
        while(series < numRows) {
            boolean mid = (series > 0 && series < numRows - 1);
            int midIncr = incr - subseries;
            for(int i = series; i < n; i+=incr) {
                sb.append(s.charAt(i));
                if (mid) {
                    if (i + midIncr < n) sb.append(s.charAt(i + midIncr));
                }
            }
            
            series++;
            subseries +=2;
        }
        
        return sb.toString();
    }
}