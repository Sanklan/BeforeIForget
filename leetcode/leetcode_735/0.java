class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<Integer>();
        for(int ast:asteroids) {
            if (ast >= 0) stack.push(ast);
            else {
                if (stack.isEmpty() || stack.peek() < 0) {
                    stack.push(ast);
                } else 
                   {
                    while(!stack.isEmpty() && stack.peek() < -1 * ast && stack.peek() > 0) 
                        stack.pop();
                    
                    boolean destroyed = false;
                    if (!stack.isEmpty() && stack.peek() >= -1 * ast) destroyed = true;
                    if (!stack.isEmpty() && stack.peek() == -1 * ast) stack.pop();

                    if (!destroyed) stack.push(ast);
                    }
                    
            }
        }

        int[] ans = new int[stack.size()];
        for(int i = stack.size() - 1; i >= 0; i--)
            ans[i] = stack.pop();

        return ans;
    }
}