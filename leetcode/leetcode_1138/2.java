class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        List<Integer> unsatisfied = new ArrayList<Integer>();
        int total = 0;
        
        int extra = 0;
        int windowSize = 0;
        int currentMax = 0;
        
        for (int i = 0; i < customers.length; i++) {
            if (windowSize == minutes) {
                int first = i - windowSize;
                currentMax -= ((grumpy[first] == 1) ? customers[first] : 0);
                windowSize--;
            }
            if (grumpy[i] == 0) {
                total += customers[i];
            }
            else {
                currentMax += customers[i];
            }
            windowSize++;
            extra = Math.max(extra, currentMax);
        }
        
        
        return total + extra;
        
    }
}