class Solution {
    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        if (s == null) return true;
        boolean hasChar = false;
        for(char c:s.toCharArray()) 
            if (Character.isAlphabetic(c) || Character.isDigit(c)) {
                hasChar = true;
                break;
            }

        if (!hasChar) return true;
        
        while(left <= right) {
            while(left <= s.length() - 1 && 
                  left <= right && 
                  !(Character.isAlphabetic(s.charAt(left)) || 
                    Character.isDigit(s.charAt(left))) ) 
                left++;
            while(right >= 0 && 
                  left <= right &&
                  !(Character.isAlphabetic(s.charAt(right)) || 
                    Character.isDigit(s.charAt(right))  )) 
                  right--;
            if (left == s.length() || right == -1 || left > right) return true;
            System.out.println(s.charAt(left) + " " + s.charAt(right));
            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                System.out.println(s.charAt(left) + " " + s.charAt(right));
                    return false;
            }
            left++;
            right--;
        }
        
        return true;
    }
}