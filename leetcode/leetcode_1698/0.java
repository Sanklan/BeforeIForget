class Solution {
    public String modifyString(String s) {
        char[] chars = s.toCharArray();
        int currentChar = 'a';
        for(int i = 0; i < chars.length; i++) {
            currentChar = (currentChar > ('a' + 25)) ? 'a' + (currentChar % ('a' + 25)) : currentChar;
            if (chars[i] == '?') {
               if (i > 0 && chars[i - 1] == (char)currentChar) {
                   if ( i < (chars.length - 1) && chars[i + 1] == (char)(currentChar + 1)) currentChar+=2;
                   else currentChar+=1;
               } else if  ( i < (chars.length - 1) && chars[i + 1] == (char)currentChar) {
                   if (i > 0 && chars[i - 1] == (char)(currentChar + 1)) currentChar+=2;
                   else currentChar+=1;
               }
                
                chars[i] = (char)currentChar;
                currentChar++;
            }
        }
        
        return new String(chars);
    }
}