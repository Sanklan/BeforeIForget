class Solution {
    public int findMaxLength(int[] nums) {
        if (nums.length <= 1) return 0;

        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int max = 0;
        map.put(0, -1);
        int count = 0;
        int i = 0;
        for(int num:nums) {
            count += ( (num == 0) ? -1 : 1);
            if (map.containsKey(count)) {
                max = Math.max(max, i - map.get(count));
            } else {
                map.put(count, i);
            }
            i++;
        }

        return max;
    }
}