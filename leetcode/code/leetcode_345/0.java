class Solution {
    public String reverseVowels(String s) {
        updateVowels();
        Queue<Integer> queue = new LinkedList<Integer>();
        Stack<Character> chars = new Stack<Character>();
        int len = s.length();
        for(int i = 0; i < len; i++) 
            if (vowels.contains(Character.toLowerCase(s.charAt(i)))) {
                queue.add(i);
                chars.push(s.charAt(i));
            }
        
        StringBuilder strblr = new StringBuilder(s);

        while(!chars.isEmpty()) {
            strblr.setCharAt(queue.poll(), chars.pop());
        }

        return strblr.toString();
    }

    private static HashSet<Character> vowels = new HashSet<Character>();
    
    private static void updateVowels() {
        if (vowels.size() == 0) {
            vowels.add('a');
            vowels.add('e');
            vowels.add('i');
            vowels.add('o');
            vowels.add('u');
        }
    }
}