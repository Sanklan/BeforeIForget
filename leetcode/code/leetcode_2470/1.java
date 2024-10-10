class Solution {
    public String removeStars(String s) {
        Stack<Character> stack = new Stack<Character>();

        for(char c:s.toCharArray()) {
            stack.push(c);
            if (stack.peek() == '*') {
                stack.pop();
                if (!stack.isEmpty()) stack.pop();
            }
        }

        StringBuilder stringBuilder = new StringBuilder();
        char chr;
        while(!stack.isEmpty()) {
            chr = stack.pop();
            stringBuilder.append(chr);
            // chr = stack.pop();
            // if (chr != '*') stringBuilder.append(chr);
            // else {
            //     int count = 1;
            //     while (!stack.isEmpty() && stack.peek() == '*')
            //     {
            //             stack.pop();
            //             count++;
            //     }
            //     while(!stack.isEmpty() && count > 0) {
            //         stack.pop();
            //         count--;
            //     }
            // }
        }

        return stringBuilder.reverse().toString();
    }
}