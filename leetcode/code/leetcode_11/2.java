class Solution {
    private static HashMap<String, Integer> memo;
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int max = 0;
       // memo = new HashMap<String, Integer>();
       // return getMax(left, right, height);
        
        while(left < right) {
            max = Integer.max(max, (right - left) * Integer.min(height[left], height[right]));
            if (height[left] < height[right]) left++;
            else right--;
        }
        return max;
    }
    
    private int getMax(int left, int right, int[] height) {
        String key = left + "_" + right;        
        if (memo.containsKey(key)) return memo.get(key);
        System.out.println(key);
        if (right - left == 1) return Integer.min(height[left] , height[right]);
        
        int leftMax = getMax(left, right - 1, height);
        int rightMax = getMax(left + 1, right, height);
        int total = (right - left) * Integer.min(height[left] , height[right]);
        
        int ret = Integer.max(Integer.max(leftMax, rightMax), total);
        memo.put(key, ret);
        return ret;
    }
}