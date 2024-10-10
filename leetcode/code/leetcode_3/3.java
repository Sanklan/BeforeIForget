class Solution {
    public int lengthOfLongestSubstring(String s) {
        char[] sArr = s.toCharArray();
        HashSet<Character> c = new HashSet<Character>(IntStream.range(0, sArr.length)
                                                     .mapToObj(i -> sArr[i]).collect(Collectors.toList()));
        int size = c.size();
        
        if (size == s.length() || size < 2) return size;
        HashSet<Character> temp = new HashSet<Character>();
        int count = 0;
        for(int i = 0; i < sArr.length; i++) {
            int j = i + 1;
            temp.clear();
            temp.add(sArr[i]);
            while(j < i + size && j < sArr.length) {
                if (temp.contains(sArr[j])) break;
                temp.add(sArr[j]);
                j++;
            }
            count = Math.max(count, temp.size());
        }
        
        return count;
    }
}