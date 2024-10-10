class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> stack = new Stack<Integer>();
        // next greater map
        HashMap<Integer, Integer> next = new HashMap<Integer, Integer>();
        for(int num:nums2) {
            while (!stack.isEmpty() && stack.peek() < num) {
                next.put(stack.pop(), num);
            }
            stack.push(num);
        }

        int[] ans = new int[nums1.length];
        for(int i = 0; i < nums1.length; i++) ans[i] = next.getOrDefault(nums1[i], -1);

        return ans;
    }
}