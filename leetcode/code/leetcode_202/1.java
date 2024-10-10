class Solution {
    public boolean isHappy(int n) {
        Long sum = (long)n;
        //HashSet<Long> checked = new HashSet<Long>();
        long temp;
        while(sum > 9) {
            // if (checked.contains(sum)) break;
            // checked.add(sum);
            temp = (long)0;
            while(sum > 0) {
                temp += (long)Math.pow(sum % 10, 2);
                sum /= 10;
            }
            sum = temp;
        }

        return sum == 1 || sum == 7;
    }

    //private static HashMap<Integer, Integer> precompute = new HashMap<Integer, Integer>();
}