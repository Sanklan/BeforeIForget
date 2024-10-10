class Solution {
    public int[] sumZero(int n) {
        int start = -1 * n / 2;
        int end = n / 2;

        int[] ret = new int[n];
        boolean isEven = n % 2 == 0;
        int index = 0;
        while(start <= end) {
            if (!(isEven && start == 0))
            {
                ret[index] = start;
                index++;
            }            
            start++;
        }

        return ret; 
    }
}