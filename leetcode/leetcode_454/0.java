class Solution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        HashMap<Integer, Integer> count = new HashMap<Integer, Integer>();
        for(int num:nums1)
            for(int sNum:nums2)
                count.put(num + sNum, count.getOrDefault(num + sNum, 0) + 1);
        
        int sum = 0;
        for(int num:nums3)
            for(int sNum:nums4)
                sum += count.getOrDefault(-(num + sNum), 0);
        
        return sum;
    }
}