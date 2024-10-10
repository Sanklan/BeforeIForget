class Solution {
    public int rob(int[] nums) {
        // 2 7 5 8 9 1 2 12 4
        memo.clear();
        return rob(nums, 0);
    }
    HashMap<Integer, Integer> memo = new HashMap<Integer, Integer>();
    private int rob(int[] nums, int index) {
        if (index >= nums.length) return 0;
        if (memo.containsKey(index)) return memo.get(index);
        
        int pick = nums[index] + rob(nums, index + 2);
        int leave = rob(nums, index + 1);

        int max = Math.max(pick, leave);
        memo.put(index, max);
        return max;
    }
}