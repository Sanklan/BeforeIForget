class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;
       HashSet<Integer> set = new HashSet<Integer>();
       for(int num:nums) set.add(num);
        int ans = 1;
       for(int num:set) {
           if ( !set.contains(num - 1)) {
               int next = num + 1;
               while (set.contains(next)) next++;
               ans = Math.max(ans, next - num);
           }
       }

       return ans;

    }
}