class Solution {
    public int arraySign(int[] nums) {
        boolean positive = true;

        for(int num:nums) {
            if (num == 0) return 0;
            if (num < 0) positive = !positive;
        }

        return (positive) ? 1 : -1;
    }
}