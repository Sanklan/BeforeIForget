class Solution {
    public int minimumOperations(int[] nums) {
        if (nums.length == 0) return 0;
        //if (nums.length == 1) ret
        int min = nums[0];
        for(int num:nums) if ((min > num && num > 0) || min == 0) min = num;

        int steps = 0, i = 0;
        boolean allZero;
        while(true) {
            allZero = true;
            for( i = 0; i < nums.length; i++) {
                if (nums[i] != 0) {
                    nums[i] -= min;
                    allZero = false;
                }
            }
            if (!allZero) steps++;
            else break;

            min = nums[0];
            for(int num:nums) if ((min > num && num > 0) || min == 0) min = num;

        }

        return steps;
    }
}