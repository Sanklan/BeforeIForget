class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] result = new int[]{1, numbers.length};
        int sum;
        while(result[0] < result[1]) {
            sum = numbers[result[0] - 1] + numbers[result[1] - 1];
            if (sum == target) return result;
            else if (sum < target) result[0]++;
            else result[1]--;
        }
        return new int[]{ -1, -1};
    }
}