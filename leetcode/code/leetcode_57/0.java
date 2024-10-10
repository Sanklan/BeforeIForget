class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> temp_interval = new ArrayList<int[]>();
        boolean added = false;
        for(int i = 0; i < intervals.length; i++) {
            if (!added) {
                if (intervals[i][1] <  newInterval[0]) {
                     temp_interval.add(intervals[i]);
                     continue;
                }
                else if (intervals[i][0] >  newInterval[1]) {
                    temp_interval.add(newInterval);
                    temp_interval.add(intervals[i]);
                    added = true;
                    continue;
                } 
                // overlap - merge
                else {
                    newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
                    newInterval[1] = Math.max(intervals[i][1], newInterval[1]);
                    continue;
                }

            
            } 
            else {
                temp_interval.add(intervals[i]);
            }
        }

        if (!added) temp_interval.add(newInterval);

        int[][] ret = new int[temp_interval.size()][];
        int j = 0;
        for (int[] intrval:temp_interval)
            ret[j++] = intrval;
        
        return ret;
    }
}