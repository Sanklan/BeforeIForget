class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int i = 0;
        int[] head = new int[matrix.length];
        for(int[] row: matrix) head[i++] = row[0];
        int index = Arrays.binarySearch(head, target);
        if (index >= 0) return true;
        index = -1 * index - 1;

        i = 0;
        for(int[] row: matrix) head[i++] = row[matrix[0].length - 1];
        int tailIndex = Arrays.binarySearch(head, target);
        if (tailIndex >= 0) return true;
        tailIndex = -1 * tailIndex - 1;

        for(;tailIndex < index; tailIndex++) {
            if (Arrays.binarySearch(matrix[tailIndex], target) >= 0) return true;
        }

        return false;
        // if (index == 0) return false;

        // int result = Arrays.binarySearch(matrix[index - 1], target);
        // return result >= 0;
    }

}