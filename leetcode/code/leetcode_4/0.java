class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int totalLength = nums1.length + nums2.length;
        // 5 -> 5/2 = [2]
        // 6 / 2 -> 0 1 [2] [3] 4 5
        Stack<Integer> stack = new Stack<Integer>();
        int mid = totalLength / 2;
        
        int i = 0;
        int j = 0;
        for(int count = 0; count <= mid; count++) {
            if (i >= nums1.length) {
                stack.push(nums2[j]);
                j++;
            }
            else if (j >= nums2.length) {
                stack.push(nums1[i]);
                i++;
            }
            else if (nums1[i] > nums2[j]) {
                stack.push(nums2[j]);
                j++;
            } else {
                stack.push(nums1[i]);
                i++;
            }
        }
        
        if (totalLength % 2 == 1) return stack.pop();
        else return (double)(stack.pop() + stack.pop()) / 2.0;
    }
}