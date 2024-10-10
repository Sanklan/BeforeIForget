class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<List<Integer>>();

        int j,k;
        for(int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            j = i + 1;
            k = nums.length - 1;
            while(j < k) {
                if (nums[j] + nums[k] == -1 * nums[i]) {
                   
                    List<Integer> a = new ArrayList<Integer>();
                    a.add(nums[i]);
                    a.add(nums[j]);
                    a.add(nums[k]);
                    result.add(a);
                    j++;k--;
                }
                else if (nums[j] + nums[k] < -1 * nums[i]) {
                    j++;
                }
                else {
                     k--;   
                }
                while(i + 1 < j && j < k && nums[j - 1] == nums[j]) j++;
            }
        }

        return result;
    }

    
}