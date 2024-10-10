class Solution {
    public boolean canJump(int[] nums) {
        map = new HashMap<Integer, Boolean>();
        return canJump(nums, 0);
    }
    HashMap<Integer, Boolean> map;
    public boolean canJump(int[] nums, int currentIndex) {
        if (currentIndex == nums.length - 1) return true;
        if (currentIndex >= nums.length) return false;
        if (nums[currentIndex] == 0) return false;
        if (map.containsKey(currentIndex)) return map.get(currentIndex);

        for(int i = nums[currentIndex]; i >= 1; i--) {
            if (canJump(nums, currentIndex + i)) {
                map.put(currentIndex, true);
                return true;
            }
        }
        map.put(currentIndex, false);
        return false;
    }
}