class Solution {
    public int uniqueMorseRepresentations(String[] words) {
       
       HashSet<String> sets = new HashSet<String>();
       
       for(String word: words) {
           StringBuilder morseCode = new StringBuilder();
           for (char c: word.toCharArray()) {
               morseCode.append(MAP[getIndex(c)]);
           }

           sets.add(morseCode.toString());
       }

       return sets.size();
    }

    private int getIndex(char c) {
        return (int)(c - 'a');
    }

    private static final String[] MAP = new String[] {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
}