class Solution {
    public int repeatedStringMatch(String A, String B) {
        StringBuilder builder = new StringBuilder(A);
        int copies = 1;
        
        while(builder.length() < B.length()) {
            builder.append(A);
            copies++;
        }
        
        if(builder.indexOf(B) >= 0)
            return copies;
        
        builder.append(A);
        copies++;
        
        if(builder.indexOf(B) >= 0)
            return copies;
        
        return -1;
    }
}