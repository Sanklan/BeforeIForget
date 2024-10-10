class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {

        for(int[] row: matrix) {
            int index = java.util.Arrays.binarySearch(row, target);
            if (index >= 0) return true;
        }

        return false;
    }
}