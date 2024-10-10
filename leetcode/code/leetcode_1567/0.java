class Solution {
    public int maxVowels(String s, int k) {
        Solution.vowel();
       int count = 0;
       int max = 0;
       int len = s.length();
       for(int i = 0; i < len; i++) {
            if (Solution.maps.contains(s.charAt(i))) count++;
            if ( i - k >= 0 && Solution.maps.contains(s.charAt(i - k))) count--;
            max = Math.max(max, count);
       }
       return max;
    }

    private static HashSet<Character> maps = new HashSet<Character>();

    private static void vowel() {
        if (maps.isEmpty()) {
            maps.add('a');
            maps.add('e');
            maps.add('i');
            maps.add('o');
            maps.add('u');
        }
    }
}