class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int[] firsts = new int[matrix.length];
        for(int i = 0; i < matrix.length; i++) firsts[i] = matrix[i][0];

        int ans = Arrays.binarySearch(firsts, target);
        if (ans >= 0) return true;
        ans = -1*(ans + 1);
        ans-=1;
        if (ans < 0) return false;

        ans = Arrays.binarySearch(matrix[ans], target );

        return ans >= 0;
    }
}