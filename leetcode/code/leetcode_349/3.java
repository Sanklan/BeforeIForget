class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> nums1HS = new HashSet<Integer>(Arrays.stream(nums1).boxed().toList());
        return Arrays.stream(nums2)
            .filter(num -> {
                boolean ret = nums1HS.contains(num);
                if (ret) nums1HS.remove(num);
                return ret;
                })
            .distinct().toArray();
    }
}