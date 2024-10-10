class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        HashSet<Integer> numOne = new HashSet<Integer>();
        HashSet<Integer> numTwo = new HashSet<Integer>();
        for(int num:nums1)
            numOne.add(num);
        for(int num:nums2) 
            numTwo.add(num);

        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        ans.add(new ArrayList<Integer>());
        ans.add(new ArrayList<Integer>());
        for(int num:numOne) {
            if (!numTwo.contains(num))
                ans.get(0).add(num);
        }

        for(int num:numTwo) {
            if (!numOne.contains(num))
                ans.get(1).add(num);
        }

        return ans;
    }
}