class Solution {
    public int maxOperations(int[] nums, int k) {
        HashMap<Integer, Integer> maps = new HashMap<Integer, Integer>();
        for(int num:nums) maps.put(num, maps.getOrDefault(num, 0) + 1);
        int count = 0;
        for(int num:nums) {
            if (maps.containsKey(num)){
                if (num == k - num) {
                    count += maps.get(num) / 2;
                } else { 
                    if (maps.containsKey(k - num)) {
                        count+= Math.min(maps.get(num), maps.get(k- num));
                        maps.remove(k - num);
                    }
                }
                maps.remove(num);
            }
        }
        return count;
    }
}