class Solution {
    public boolean parseBoolExpr(String expression) {
        // operation + range
        return process(expression.toCharArray());
    }
    
    private boolean process(char[] expression) {
        boolean result = true;
        char operator = expression[global++];
        // ignoreing ( 
        global++;
        
        while(expression[global] != ')') {
            char current = expression[global];
            char previous = expression[global - 1];
            if (current != ',') {
            boolean currentB;
            if (current == '|' || current == '&' || current == '!' )
                currentB = process(expression);
            else currentB = current == 't';
            
            if (previous == '(') {
                if (operator == '!') result = ! (currentB); 
                else result = currentB;
            } else {
                result = (operator == '&') ? (result & currentB): (result || currentB); 
            }
            }
            global++;
        }        
        return result;
    }
    
    //donantes current char
    int global = 0;
}