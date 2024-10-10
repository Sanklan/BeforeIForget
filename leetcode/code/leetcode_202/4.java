class Solution {
    public boolean isHappy(int n) {
        Long sum = (long)n;
        HashSet<Long> checked = new HashSet<Long>();
        while(sum > 1) {
            if (checked.contains(sum)) break;
            checked.add(sum);
            Long temp = (long)0;
            while(sum > 0) {
                temp += (long)Math.pow(sum % 10, 2);
                sum /= 10;
            }
            sum = temp;
        }

        return sum == 1;
    }
}