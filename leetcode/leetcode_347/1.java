class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> count = new HashMap<Integer, Integer>();
        for (int n:nums) count.put(n, count.getOrDefault(n, 0) + 1);
        
        List<Integer> ans = count.entrySet().stream()
            .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
            .limit(k)
            .map(Map.Entry::getKey)
            .collect(Collectors.toList());
        
        int[] res = new int[k];
        int i = 0;
        for(int a:ans) res[i++] = a;
        
        return res;
    }
}