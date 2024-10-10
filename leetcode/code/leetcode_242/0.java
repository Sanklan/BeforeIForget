class Solution {
    public boolean isAnagram(String s, String t) {
        return compare(count(s), count(t));
    }

    int[] count(String s) {
        int[] c = new int[26];
        for(char chr:s.toCharArray()) c[chr - 'a']++;
        return c;
    }

    boolean compare(int[] a1, int[] a2) {
        int i = 0;
        while(i < 26) {
            if (a1[i] != a2[i]) return false;
            i++;
        }

        return true;
    }
}