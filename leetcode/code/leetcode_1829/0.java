class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, new Comparator<int[]>() {
            public int compare(int[] A, int[] B) {
                return B[1] - A[1];
            }
        } );

        int max = 0;
        for(int[] boxType:boxTypes) {
            if (truckSize <= 0) break;

            max += ((int)Math.min(truckSize, boxType[0]) * boxType[1]);
            truckSize -= boxType[0];
        }

        return max;
    }
}