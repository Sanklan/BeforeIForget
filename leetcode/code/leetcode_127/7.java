class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (beginWord.equals(endWord) || beginWord.length() != endWord.length()) return 0;
        HashSet<String> set = new HashSet<String>(wordList);
        if (!set.contains(endWord)) return 0;

        Queue<String> bfs = new LinkedList<String>();
        bfs.add(beginWord);
        set.remove(beginWord);
        int size, steps = 1, len = beginWord.length();
        String buf;

        // O(n)
        while(!bfs.isEmpty()) {
            size = bfs.size();
            while(size > 0) {
                buf = bfs.poll();
                for(String next:generate(buf, set, len)) {
                    // found the answer
                    if (next.equals(endWord)) return steps + 1;
                    if (set.contains(next)) {
                        set.remove(next);
                        bfs.add(next);
                    }
                }
                size--;
            }
            steps++;
        }

        // didn't find the answer
        return 0;
    }

    // w * 26
    private List<String> generate(String word, HashSet<String> set, int len) {
        List<String> ans = new ArrayList<String>();

        for(String s:set) {
            if (match(word, s)) ans.add(s);
        }
        // HashSet<String> uniq = new HashSet<String>();
        // char[] str;
        // for(int index = 0; index < len; index++) {
        //     str = word.toCharArray();
        //     for(int c = 0; c < 26; c++) {
        //         str[index] = (char)('a' + c);
        //         uniq.add(new String(str));
        //     }
        // }

        // return new ArrayList<String>(uniq);
        return ans;

    }

    private boolean match(String word, String next) {
        int count = 0;
        if (word.length() != next.length()) return false;
        for(int i = 0; i < word.length(); i++) if (word.charAt(i) != next.charAt(i)) count++;
        return count == 1;
    }


}