class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer, Integer> count = new HashMap<Integer, Integer>();
        for(int num:arr) count.put(num, count.getOrDefault(num, 0) + 1);
        HashSet<Integer> frequency = new HashSet<Integer>();
        for(int freq:count.values()) {
            if (frequency.contains(freq)) return false;
            frequency.add(freq);
        }
        return true;
    }
}