class Solution {
    public List<String> generateParenthesis(int n) {
        guess(0,0, "", n);
        return allStrings;
    }
    
    private void guess(int open, int close, String current, int n) {       
        if (open == n) {
             if (close == n) {
                    allStrings.add(current);
            }
            else guess(open, close + 1, current + ")", n);
        }
        else if (open <= close) {
            guess(open + 1, close, current + "(", n);            
        }
        else {
            guess(open, close + 1, current + ")", n);
            guess(open + 1, close, current + "(", n);
        }
    }
    
    private List<String> allStrings = new ArrayList<String>();
}