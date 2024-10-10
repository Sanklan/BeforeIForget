class Solution {
    public String removeStars(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        int len = 0;
        for(char c:s.toCharArray()) {
           if ( c == '*') {
            len--;
            stringBuilder.deleteCharAt(len);
           } else {
            stringBuilder.append(c);
            len++;
           }
        }

        
        // char chr;
        // while(!stack.isEmpty()) {
        //     chr = stack.pop();
        //     stringBuilder.append(chr);
        //     // chr = stack.pop();
        //     // if (chr != '*') stringBuilder.append(chr);
        //     // else {
        //     //     int count = 1;
        //     //     while (!stack.isEmpty() && stack.peek() == '*')
        //     //     {
        //     //             stack.pop();
        //     //             count++;
        //     //     }
        //     //     while(!stack.isEmpty() && count > 0) {
        //     //         stack.pop();
        //     //         count--;
        //     //     }
        //     // }
        // }

        return stringBuilder.toString();
    }
}