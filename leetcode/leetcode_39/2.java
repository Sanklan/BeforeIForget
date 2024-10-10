class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        recur(candidates, target, 0); 

        //for(String str:)
        if (memo.containsKey(0 + "_" + target))
            return memo.get(0 + "_" + target);
        
        return (List<List<Integer>>) new ArrayList<List<Integer>>();
    }
    // from this index, sum and list of possible answer
    HashMap<String, List<List<Integer>>> memo = new HashMap<String, List<List<Integer>>>();

    private void recur(int[] candidates, int target, int index) {
        if (index >= candidates.length || target < candidates[index]) return;
        
        memo.put(index + "_" + target, new ArrayList<List<Integer>>());
        int sum = 0;
        if (target > candidates[index]) {
            
            List<Integer> start = new ArrayList<Integer>();
            do {
                recur(candidates, target - sum, index + 1);
                if (memo.containsKey((index + 1) + "_" + (target - sum)) && 
                    memo.get((index + 1) + "_" + (target - sum)).size() > 0) {
                        for(List<Integer> sub:memo.get((index + 1) + "_" + (target - sum))) {
                            List<Integer> arr = new ArrayList<Integer>(start);
                            arr.addAll(sub);
                            memo.get(index + "_" + target).add(arr);
                        }
                }

                start.add(candidates[index]);
                sum += candidates[index];
            } while(sum < target);

            if (sum == target) memo.get(index + "_" + target).add(new ArrayList<Integer>(start));

        } 
        
        if (target == candidates[index]) {
            List<Integer> arr = new ArrayList<Integer>();
            arr.add(target);
            memo.get(index + "_" + target).add(arr);
        }
    }
}