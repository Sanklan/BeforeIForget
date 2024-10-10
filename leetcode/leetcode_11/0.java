class Solution {
    public int maxArea(int[] height) {
        int left[] = new int[height.length];
        int right[] = new int[height.length];
        left[0] = height[0];
        right[height.length - 1] = height[height.length - 1];
        for(int i = 1; i < height.length; i++) 
            left[i] = Math.max(height[i], left[i-1]);
        for(int i = height.length - 2; i>=0; i--) 
            right[i] = Math.max(height[i], right[i+1]);
        
        int i = 0, j = height.length - 1;
        int max = Integer.MIN_VALUE;
        while(i < j) {
            max = Math.max(max, (j - i) * Math.min(left[i], right[j]));
            if (left[i] < right[j]) i++;
            else j--;
        }

        return max;
    }
}