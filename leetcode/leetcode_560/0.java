class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int sum = 0;
        int count = 0;
        for(int n:nums) {
            sum += n;
            if (map.containsKey(sum - k)) {
                count += map.get(sum - k);
            } 
            map.put(sum, map.getOrDefault(sum, 0) + 1);

            if (sum == k) count++;
        }

        return count;
    }
}