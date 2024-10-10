class Solution {
    public int maximumScore(int[] nums, int[] multipliers) {
        /*
        [1,2,3]
        [3,2,1]
        */
        return maximumScore(nums, multipliers, 0, nums.length - 1, 0);
    }

    private int maximumScore(int[] nums, int[] multipliers, int i , int j, int m) {
        if (m == multipliers.length) return 0;
        String key = i + "_" + j + "_" + m;
        if (memo.containsKey(key)) return memo.get(key);
        int max = Math.max(nums[i] * multipliers[m] + maximumScore(nums, multipliers, i + 1, j, m + 1),
                           nums[j] * multipliers[m] + maximumScore(nums, multipliers, i, j - 1, m + 1));
        memo.put(key, max);
        return max;
    }

    private HashMap<String, Integer> memo = new HashMap<String, Integer>();
}