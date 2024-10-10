class Solution {
    public int getKth(int lo, int hi, int k) {
        for(int i = lo; i <= hi; i++) steps(i);
        TreeMap<Integer, List<Integer>> sortedSteps = new TreeMap<Integer, List<Integer>>();
        for(int i = lo; i <= hi; i++) {
            int step = memo.get(i);
            if (!sortedSteps.containsKey(step)) 
                sortedSteps.put(step, new ArrayList<Integer>());
            
            sortedSteps.get(step).add(i);
        }
        int ans = -1;
        for(Integer key:sortedSteps.keySet()) {
            int step = sortedSteps.get(key).size();
            if (k > step) k -= step;
            else {
                List<Integer> data = sortedSteps.get(key);
                Collections.sort(data);
                ans = data.get(k - 1);
                break;
            }
        }

        return ans;


    }

    int next(int x) {
        return (x % 2 == 0) ? x/2 : 3 * x + 1;
    }

    int steps(int n) {
        if (memo.containsKey(n)) return memo.get(n);
        if (n == 1) {
            memo.put(1, 0);
            return 0;
        }
        int steps = 1 + steps(next(n));
        memo.put(n, steps);
        return steps;
    }
    private static final HashMap<Integer, Integer> memo = new HashMap<Integer, Integer>();
}