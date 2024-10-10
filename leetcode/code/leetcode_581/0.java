class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int min = Integer.MAX_VALUE;
        boolean flag = false;
        for(int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                flag = true;
            }
            if (flag) {
                min = Math.min(min, nums[i + 1]);
            }
        }

        int max = Integer.MIN_VALUE;
        flag = false;
        for(int i = nums.length - 1; i > 0; i--) {
            if (nums[i] < nums[i - 1]) {
                flag = true;
            }
            if (flag) {
                max = Math.max(max, nums[i - 1]);
            }
        }

        int l = nums.length;
        for(l = 0; l < nums.length; l++) {
            if (nums[l] > min) {
                break;
            }
        }

        int r = -1;
        for(r = nums.length - 1; r >=0; r--) {
            if (nums[r] < max) {
                break;
            }
        }
        //System.out.println(l + " " + r);
        return r - l < 0 ? 0 : r - l + 1;

    }


}