class Solution {
    public int maxSumTwoNoOverlap(int[] nums, int firstLen, int secondLen) {
        
        int[] fSum = rangeSum(nums, firstLen);
        int[] sSum = rangeSum(nums, secondLen);
        
        // System.out.println(Arrays.toString(fSum));
        // System.out.println(Arrays.toString(sSum));
        
        int[] fmax = getmax(fSum, firstLen, true);
        int[] smax = getmax(sSum, secondLen, false);

        // System.out.println(Arrays.toString(fmax));
        // System.out.println(Arrays.toString(smax));
        int max = 0;
        for(int i = 0; i < nums.length - firstLen; i++) {
            if (i + firstLen + secondLen <= nums.length) {
                max = Math.max(fmax[i] + smax[i + firstLen], max);
            }
        }

        fmax = getmax(fSum, firstLen, false);
        smax = getmax(sSum, secondLen, true);

        // System.out.println(Arrays.toString(fmax));
        // System.out.println(Arrays.toString(smax));
        for(int i = 0; i < nums.length - secondLen; i++) {
            if (i + firstLen + secondLen <= nums.length) {
                max = Math.max(fmax[i + secondLen] + smax[i], max);
            }
        }

        return max;
    }


    private int[] rangeSum(int[] nums, int firstLen) {
        int[] fSum = new int[nums.length];
        int i = 0, sum = 0;
        while( i < firstLen) sum += nums[i++];
        fSum[0] = sum;
        while(i < nums.length) {
            sum = sum - nums[i - firstLen] + nums[i];
            fSum[i - firstLen + 1] = sum;
            i++;
        }

        return fSum;
    }

    private int[] getmax(int[] sum,int windowSize, boolean direction) {
        int[] max = new int[sum.length];
        
        if (direction) max[0] = sum[0];
        else max[sum.length - windowSize] = sum[sum.length - windowSize];
        int i = (direction) ? 1 : sum.length - windowSize - 1;
        while(i >= 0 && i <= sum.length - windowSize) {
            if (direction) {
                max[i] = Math.max(max[i -1], sum[i]);
                i++;
            } else {
                max[i] = Math.max(max[i + 1], sum[i]);
                i--;
            }
        }

        return max;
    }
}