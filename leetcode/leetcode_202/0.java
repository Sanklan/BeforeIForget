class Solution {
    public boolean isHappy(int n) {
        long sum = n;
        long temp;
        while(sum > 9) {
            temp = 0;
            while(sum > 0) {
                temp += Math.pow(sum % 10, 2);
                sum /= 10;
            }
            sum = temp;
        }

        return sum == 1 || sum == 7;
    }

}