class Solution {
    public int minimumOperations(int[] nums) {
        if (nums.length == 0) return 0;
        int min = nums[0];
        for(int num:nums) if ((min > num && num > 0) || min == 0) min = num;

        int steps = 0, i = 0;
        int tempMin;
        boolean allZero;
        while(min > 0) {
            allZero = true;
            tempMin = 0;
            for( i = 0; i < nums.length; i++) {
                if (nums[i] != 0) {
                    nums[i] -= min;
                    allZero = false;
                }
                if ((tempMin > nums[i] && nums[i] > 0) || tempMin == 0) tempMin = nums[i];
            }
            if (allZero) break;
            steps++;
            min = tempMin;
        }

        return steps;
    }
}