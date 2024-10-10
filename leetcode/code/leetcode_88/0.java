class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        
        if (n == 0) return;
        /*for (int i = 0; i < n; i++) nums1[ i + m] = nums2[i];
        if (m == 0) {
           return;
        }*/
        int k = m + n - 1;
        int left = m - 1;
        int right = n - 1;
        while(left >= 0 && right >= 0) {
            if (nums1[left] >= nums2[right]) {
                nums1[k] = nums1[left];
                left--;
                k--;
            } else {
                nums1[k] = nums2[right];
                right--;
                k--;
            }
        }

        while(right >= 0) nums1[k--] = nums2[right--];
        
    }
}