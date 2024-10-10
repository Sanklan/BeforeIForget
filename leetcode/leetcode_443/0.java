class Solution {
    public int compress(char[] chars) {
        int index = 0;
        StringBuilder str = new StringBuilder();
        while(index < chars.length) {
            char c = chars[index];
            int count = 1;
            index += 1;
            while(index < chars.length && chars[index] == c) 
            {
                count++;
                index++;
            }
            str.append(c);
            if (count > 1) str.append(count);
        }

        int length = str.length();
        index = 0;
        while(index < length) {
            chars[index] = str.charAt(index++);
            //index++;
        }
        return length;
    }

    
    
}