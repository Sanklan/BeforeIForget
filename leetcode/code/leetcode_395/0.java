class Solution {
    public int longestSubstring(String s, int k) {
        //number of unique characters 
        // sliding window 
        HashMap<Character, Integer> count = new HashMap<Character, Integer>();
        int n = s.length();
        int uniques = countUniqueCharacters(s);
        int max = Integer.MIN_VALUE;
        for(int unique = 1; unique <= uniques; unique++) {
            count.clear();
            int left = 0;
            int right = 0;
            //System.out.println(unique);
            while(right < n) {
                char c = s.charAt(right);
                if (left != right && count.size() == unique && !count.containsKey(c)) {
                    char r = s.charAt(left);
                    count.put(r,  count.getOrDefault(r, 0) - 1);
                    if (count.get(r) == 0) count.remove(r);
                    left++;
                } else {
                    count.put(c, count.getOrDefault(c, 0) + 1);
                    boolean match = (count.values().stream().filter(x -> x < k).count() == 0);
                    if (match) {
                        max = Math.max(max, right - left + 1);
                    }
                    right++;
                }

                /*count.entrySet().forEach(entry -> {
                        System.out.println(entry.getKey() + " " + entry.getValue());
                    });*/
            }
        }

        return (max == Integer.MIN_VALUE) ? 0 : max;
    }

    private int countUniqueCharacters(String s) {
        HashSet<Character> set = new HashSet<Character>();
        for(char c:s.toCharArray()) set.add(c);
        return set.size();
    }

    
}