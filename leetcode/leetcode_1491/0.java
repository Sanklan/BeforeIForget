class Solution {
    public int numTimesAllBlue(int[] flips) {
        boolean[] position = new boolean[flips.length];
        Arrays.fill(position, false);
        int step = 0;
        int result = 0;
        int falsePos = 0;
        int truePos = -1;
        while(step < flips.length) {
            int p = flips[step] - 1;
            position[p] = true;
            
            if (p >= truePos) truePos = p;
            if (p == falsePos) {
                for(int i = p + 1; i < position.length; i++) 
                    if(!position[i]) {
                        falsePos = i;
                        break;
                    }
            }
            
            if (step == truePos && (step + 1 == falsePos || step + 1 == position.length)) result++;
            
            step++;
        }
        
        return result;
    }
}