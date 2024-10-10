class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int[] shorter = (nums1.length >= nums2.length) ? nums2 : nums1;
        int[] longer = (nums1.length >= nums2.length) ? nums1 : nums2;

        int s = 0;
        int l = 0;
        ArrayList<Integer> ans = new ArrayList<Integer>();
        while(s < shorter.length && l < longer.length) {
            if (shorter[s] == longer[l]) {
                ans.add(shorter[s]);
                s++; l++;
            } else if (shorter[s] < longer[l]) {
                s++;
            } else {
                l++;
            }
        }

        int[] ret = new int[ans.size()];
        IntStream.range(0, ret.length).forEach( i -> ret[i] = ans.get(i));

        return ret;
    }
}