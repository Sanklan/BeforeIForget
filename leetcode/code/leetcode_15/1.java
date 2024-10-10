class Solution {
    public List<List<Integer>> threeSum(int[] nums) {        
       
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        HashSet<Integer> set = new HashSet<Integer>();
        HashSet<String> r = new HashSet<String>();
        
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++)
            {
                int sum = -1 * (nums[i] + nums[j]);
                if (set.contains(sum)) {
                    if (r.contains(sum + "_" + nums[i] + "_" + nums[j] + "_")) continue;
                    List<Integer> list = new ArrayList<Integer>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(sum);
                    Collections.sort(list);
                    
                    String y = "";
                    for(Integer k: list) {
                        y += k + "_";                        
                    }
                    if (r.contains(y)) continue;
                    r.add(y);
                    result.add(list);
                } //if                
                
            } // for
            
            set.add(nums[i]);
        } // for
        
        return result;   
    }

}