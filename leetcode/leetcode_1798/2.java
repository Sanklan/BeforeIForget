class Solution {
    public int maxOperations(int[] nums, int k) {
        HashMap<Integer, Integer> maps = new HashMap<Integer, Integer>();
        for(int num:nums) maps.put(num, maps.getOrDefault(num, 0) + 1);
        int count = 0;
        for(int num:nums) {
            if (maps.containsKey(num)){
                if (maps.get(num) == 1) maps.remove(num);
                else maps.put(num, maps.get(num) - 1);
                if (maps.containsKey(k - num)) {
                    count++;
                    if (maps.get(k - num) == 1) maps.remove(k - num);
                    else maps.put(k - num, maps.get(k - num) - 1);
                }
            }
        }
        return count;
    }
}