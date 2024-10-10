class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> ret = new ArrayList<String>();
        build();
        if(digits.length() > 0)
            comb("", digits, 0, ret);
        return ret;
    }
    
    private void comb(String currentString, String digits, int index, List<String> ret) {
         if (index == digits.length()) {
             ret.add(currentString);
             return;
         }
        char[] arr = phone.get(digits.charAt(index)).toCharArray();
        for(char c: arr) comb(currentString + c, digits, index + 1, ret);
        
    }
    private static void build() {
        if (phone.size() > 0) return;
        phone.put('2', "abc");
        phone.put('3', "def");
        phone.put('4', "ghi");
        phone.put('5', "jkl");
        phone.put('6', "mno");
        phone.put('7', "pqrs");
        phone.put('8', "tuv");
        phone.put('9', "wxyz");        
        
    }
    
    static HashMap<Character, String> phone = new HashMap<Character, String>();
}