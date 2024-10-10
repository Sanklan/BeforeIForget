class Solution {
    public String decodeString(String s) {
        Stack<Character> stack = new  Stack<Character>();
        StringBuilder strbldr = new StringBuilder();
        String stringBuffer;
        char[] chars;
        for(char chr:s.toCharArray()) {
            if (chr != ']') {
                stack.push(chr);
            } else {
                strbldr.setLength(0);
                while(stack.peek() != '[') strbldr.append(stack.pop());
                stack.pop();
                stringBuffer = strbldr.reverse().toString();
                
                strbldr.setLength(0);
                while(!stack.isEmpty() && Character.isDigit(stack.peek()))
                    strbldr.append(stack.pop());
                int count = Integer.parseInt(strbldr.reverse().toString());

                chars = stringBuffer.toCharArray();
                while(count > 0 && chars.length > 0) {
                    for(char c:chars) stack.push(c);
                    count--;
                }

            }
        }// for ends

        strbldr.setLength(0);
        while(!stack.isEmpty()) strbldr.append(stack.pop());
        return strbldr.reverse().toString();

    }
}