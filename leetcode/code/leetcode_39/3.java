class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        //Arrays.sort(candidates);
        List<List<Integer>> result = combination(candidates, target);
        HashSet<String> set = new HashSet<String>();
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        for(List<Integer> entry:result) {
            String s = string(entry);
            if (!set.contains(s)) {
                set.add(s);
                ans.add(entry);
            } 
        }
        return ans;
    }

    private List<List<Integer>> combination(int[] c, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        for (int k:c) {
            int diff = target - k;
            if (diff == 0) {
                List<Integer> r = new ArrayList<Integer>();
                r.add(k);
                result.add(r);
            } else if (diff > 0) {
                List<List<Integer>> r = combination(c, diff);
                if (r.size() > 0) {
                    for(List<Integer> g:r) {
                        if (g.size() > 0) {
                            g.add(k);
                            result.add(g);
                        }
                    }
                }
            }
        }

        return result;
    }

    private HashMap<Integer, HashSet<String>> memo;


    private String string(List<Integer> r) {
        Collections.sort(r);
        StringBuilder sb = new StringBuilder();
        for(int h:r) sb.append(h + "_");
        return sb.toString();
    }
}


