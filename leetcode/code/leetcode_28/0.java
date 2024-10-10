class Solution {
    public int strStr(String haystack, String needle) {
        int len = haystack.length();
        int nLen = needle.length();
        char c = needle.charAt(0);
        List<Integer> startIndex = new ArrayList<Integer>();
        
        IntStream.range(0, len)
        .filter( index -> haystack.charAt(index) == c)
        .forEach(index -> startIndex.add(index));

        for(int index:startIndex) {
            if (index + nLen > len) break;

            if (haystack.substring(index, index + nLen).equals(needle)) return index;
        }


        return -1;
    }
}