class Solution {
    public int minimumOperations(int[] nums) {

        if (nums.length == 0) return 0;

        HashSet<Integer> set = new HashSet<Integer>();
        for(int num:nums) if (num != 0) set.add(num);
        return set.size();
        // int min = nums[0];
        // for(int num:nums) if ((min > num && num > 0) || min == 0) min = num;

        // int steps = 0, i = 0;
        // int tempMin;
        // boolean allZero;
        // while(min > 0) {
        //     allZero = true;
        //     tempMin = 0;
        //     for( i = 0; i < nums.length; i++) {
        //         if (nums[i] != 0) {
        //             nums[i] -= min;
        //             allZero = false;
        //         }
        //         if (nums[i] > 0 && (tempMin > nums[i] || tempMin == 0)) tempMin = nums[i];
        //     }
        //     if (allZero) break;
        //     steps++;
        //     min = tempMin;
        // }

        // return steps;
    }
}