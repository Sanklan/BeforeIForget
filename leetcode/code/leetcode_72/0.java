class Solution {
    public int minDistance(String word1, String word2) {
        int length1 = word1.length();
        int length2 = word2.length();

        /*if (length1 < length2)
            while(length1 < length2) {
                word1 += ' ';
                length1++;
            }
        else 
            while(length2 < length1) {
                word2 += ' ';
                length2++;
            }*/
        
        int[][] cost = new int[length1 + 1][length2 + 1];

        for(int i = 0; i <= length1; i++) {
            //cost[0][i] = i;
            cost[i][0] = i;
        }

        for(int i = 0; i <= length2; i++) {
            //cost[0][i] = i;
            cost[0][i] = i;
        }
        int i = 0, j = 0;
        for(i = 1; i <= length1; i++) {
            for(j = 1; j <= length2; j++) {
                // match or replace
                cost[i][j] = cost[i-1][j-1] + 
                    ((word1.charAt(i - 1) == word2.charAt(j -1)) ? 0 : 1);
                
                cost[i][j] = Math.min(cost[i][j], 1 + cost[i][j - 1]);
                cost[i][j] = Math.min(cost[i][j], 1 + cost[i - 1][j]);
            }
        }
    

        return cost[length1][length2];

    }
}