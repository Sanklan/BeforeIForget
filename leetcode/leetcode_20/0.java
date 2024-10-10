class Solution {
    public boolean isValid(String s) {
        if ( s == null || s.length() == 0) return true;
        HashMap<Character, Character> pairs = new  HashMap<Character, Character>();
        pairs.put(')', '(');
        pairs.put('}', '{');
        pairs.put(']', '[');
        
        Stack<Character> stack = new Stack<Character>();
        
        for(Character c:s.toCharArray()) {
            if (!pairs.containsKey(c)) stack.push(c);
            else if (pairs.containsKey(c) 
                     && (stack.empty() || pairs.get(c) != stack.peek())) 
                return false;
            else stack.pop();
        }
        
        return stack.empty();
        
    }
}