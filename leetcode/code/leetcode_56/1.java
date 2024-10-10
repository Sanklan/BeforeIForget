class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return a[0] - b[0];
            }
        });

        int time = intervals[0][1];
        int[] current = Arrays.copyOf(intervals[0], 2);
        List<int[]> ansList = new ArrayList<int[]> ();
        for(int i = 1; i < intervals.length; i++) {
            // overlapping 
            if (time >= intervals[i][0]) {
                current[1] = Math.max(current[1], intervals[i][1]);
                time = Math.max(current[1], intervals[i][1]);
            }

            // non overlapping 
            else {
                ansList.add(current);
                current = Arrays.copyOf(intervals[i], 2);
                time = current[1];
            }
        }
        int len = ansList.size();
        if (ansList.size() == 0 || ansList.get(len -1)[1] < current[0]) {
            ansList.add(current);
            len++;
        }

        int[][] ans = new int[len][2];
        int i = 0;
        for(int[] interval:ansList) {
            ans[i][0] = interval[0];
            ans[i++][1] = interval[1];
        }

        return ans;
        
    }
}