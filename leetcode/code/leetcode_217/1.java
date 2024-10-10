import java.util.*;
class Solution {
    public boolean containsDuplicate(int[] nums) {
       HashSet<Integer> temp = new HashSet<Integer>();
       Arrays.stream(nums).forEach(temp::add);
       return temp.size() != nums.length;
       /* HashSet<Integer> nonDup = new HashSet<Integer>();
        for(int i = 0; i < nums.length; i++) {
            if (nonDup.contains(nums[i]))
                return true;
            nonDup.add(nums[i]);
        }
        return false;*/
    }
}