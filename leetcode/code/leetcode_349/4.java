class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> nums1HS = new HashSet<Integer>(Arrays.stream(nums1).boxed().toList());
        return Arrays.stream(nums2)
            .filter(num -> nums1HS.contains(num))
            .distinct().toArray();
    }
}