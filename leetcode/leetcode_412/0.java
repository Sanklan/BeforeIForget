class Solution {
    public List<String> fizzBuzz(int n) {
        List<String> ret = new ArrayList<String>();
        
        int i = 1;
        while( i <= n) {
            if ( i % 3 == 0 && i % 5 == 0) ret.add("FizzBuzz");
            else if (i % 3 == 0) ret.add("Fizz");
            else if (i % 5 == 0) ret.add("Buzz");
            else ret.add("" + i);
            
            i++;
        }
        
        
        return ret;
    }
}