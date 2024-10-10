class Solution {
    public int minAddToMakeValid(String s) {
        /**
        (( (()) (((()))) ))

          
         ((((( (((()))) ((())) )))))

         // closing > opening -> append in starting '('
         // closing < opening  -> append in end ')' 
         // '(' < ')'
         // ))())(((

         */

         Stack<Integer> startOpening = new Stack<Integer>();
         int opening = 0;
         int closing = 0;
         int sum = 0;

         for(char c:s.toCharArray()) {
             if (opening > 0 && opening == closing) 
             {
                opening = 0;
                closing = 0;
            }
            if (c == ')') 
            {
                closing++;
            }
            else
            {
                if (opening >= closing) 
                {
                     opening++;
                }
                else 
                {
                    sum += closing;
                    closing = 0;
                    opening = 1;
                }
            }
         }

         return sum + Math.abs(opening - closing);
    }
}