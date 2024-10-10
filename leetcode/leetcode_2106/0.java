class Solution {
    public int findGCD(int[] nums) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int num:nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }

        if (max % min == 0) return min;
        int n = min / 2;
        while(n > 1) {
            if (max % n == 0 && min % n == 0) return n;
            n--;
        }

        return 1;
    }
}