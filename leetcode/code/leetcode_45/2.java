class Solution {
    public int jump(int[] nums) {
        int[] memo = new int[nums.length];
        Arrays.fill(memo, Integer.MAX_VALUE);
        memo[nums.length - 1] = 0;
        //minJump(nums, 0, memo);
        //System.out.println(Arrays.toString(memo));

        for(int i = nums.length - 2; i >= 0; i--) {
            for(int j = 1; j <= nums[i]; j++) {
                if(i + j < nums.length) {
                    if (memo[i + j] < Integer.MAX_VALUE) {
                        memo[i] = Math.min(memo[i], 1 + memo[i + j]);
                    }
                } else {
                    break;
                }
            }
        }
        return memo[0];
    }

    int minJump(int[] nums, int currentIndex, int[] memo) {
        if (currentIndex >= nums.length - 1) return 0;
        if (memo[currentIndex] < Integer.MAX_VALUE) return memo[currentIndex];
        int maxJump = Integer.MAX_VALUE - 1;
        for(int i = 1; i <= nums[currentIndex]; i++) {
           maxJump = Math.min(maxJump, 1 + minJump(nums, currentIndex + i, memo));
        }

        memo[currentIndex] = maxJump;
        //System.out.println(Arrays.toString(memo));
        return maxJump;
    }
}