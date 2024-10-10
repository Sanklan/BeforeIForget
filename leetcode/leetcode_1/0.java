import java.util.*;

class Solution {
    public int[] twoSum(int[] nums, int target) {
     HashMap<Integer, Integer> data = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            data.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            if(data.containsKey(target - nums[i])) {
                if (i != data.get(target - nums[i]))
                    return new int[] {i, data.get(target - nums[i])};
            }
        }
        
        return new int[0];
    }
}