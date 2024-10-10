import java.util.Arrays;
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int max = Integer.MAX_VALUE;
        for(int i = 0; i < nums.length; i++) {
            int left = i + 1; 
            int right = nums.length - 1;
            while(left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == target) return sum;
                else if (sum < target) left++;
                else right--;
                max = getClosed(target, max, sum);
            }
        }
        
        return max;
    }
    
    private int getClosed(int target, int a, int b) {
        return (Math.abs(target - a) > Math.abs(target - b)) ? b : a;
    }
}