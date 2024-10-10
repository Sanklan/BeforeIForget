class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int[] sum = new int[cardPoints.length];
        sum[0] = cardPoints[0];
        for(int i = 1; i < cardPoints.length; i++) 
            sum[i] = sum[i- 1] + cardPoints[i];
        
        int s = sum[k - 1];
        if (k == cardPoints.length) return s;
        s = Math.max(s, sum[cardPoints.length - 1] - sum[cardPoints.length - k - 1]);
        for(int start = 1; start <= k; start++) {
            int end = k - start;
            s = Math.max(s, sum[start - 1] + sum[cardPoints.length - 1] - sum[cardPoints.length - 1 - end]);
        }

        return s;
        //return getMax(cardPoints, 0, cardPoints.length - 1, k);
    }

    int getMax(int[] cardPoints, int i, int j, int k) {
        if (k == 0) return 0;
        if (memo.containsKey(i + "_" + j)) return memo.get(i + "_" + j);

        int max =  Math.max(cardPoints[i]+ getMax(cardPoints, i + 1, j, k -1),
                            cardPoints[j]+ getMax(cardPoints, i, j - 1, k -1));

        memo.put(i + "_" + j, max);

        return max;
    }

    HashMap<String, Integer> memo = new HashMap<String, Integer>();
}