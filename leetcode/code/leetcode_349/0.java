class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> nums1HS = new HashSet<Integer>(Arrays.stream(nums1).boxed().toList());
       /* ArrayList<Integer> nums2LS = new ArrayList<Integer>(Arrays.stream(nums2).boxed().toList());
        for(int i = nums2.length - 1; i >= 0; i--) {
            int n = nums2[i];
            if (nums1HS.contains(n)) {
                nums1HS.remove(n);
            } else {
                nums2LS.remove(i);
            }
        }
        
        return nums2LS.stream().mapToInt(Integer::intValue).toArray();*/
       return Arrays.stream(nums2)
            .filter(num -> {
                boolean ret = nums1HS.contains(num);
                if (ret) nums1HS.remove(num);
                return ret;
                })
            .toArray();
    }
}