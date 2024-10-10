class Solution {
    public List<List<Integer>> permute(int[] nums) {
    
        return generateSequence(nums, new HashSet<Integer>());
        
    }
    // selected will be indexes of numbers already included
    private List<List<Integer>> generateSequence(int[] nums, HashSet<Integer> selected) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (nums.length == selected.size()) return result;
        
        for(int i = 0; i < nums.length; i++) {
           // System.out.println(selected.contains(i));
            if (!selected.contains(i)) {
                selected.add(i);
                List<List<Integer>> subsequences = generateSequence(nums, selected);
                if (subsequences.size() == 0) {
                    List<Integer> subsequence = new ArrayList<Integer>();
                    subsequence.add(nums[i]);
                    subsequences.add(subsequence);
                } else {
                    for(List<Integer> subsequence:subsequences) {
                        subsequence.add(0, nums[i]);
                   //     subsequence.stream().forEach(System.out::println);
                    } 
                }
                
                for(List<Integer> subsequence:subsequences) result.add(subsequence);
                selected.remove(i);
                
            }
        }
       // for(List<Integer> r:result) result.stream().forEach(System.out::println);
        return result;
        
    }
}