class Solution {
    public int[] plusOne(int[] digits) {
        int extra = 1;
        LinkedList<Integer> ret = new LinkedList<Integer>();
        for (int i = digits.length - 1; i >= 0; i--) {
            ret.add(0, (digits[i] + extra) % 10);
            extra = (digits[i] + extra) / 10;
            //if (extra == 0) break;
        }
        
        if (extra > 0) ret.add(0, extra);
        
        int[] retArr = new int[ret.size()];
        IntStream.range( 0 , retArr.length).forEach(i -> retArr[i] = ret.get(i));
        return retArr;
    }
}