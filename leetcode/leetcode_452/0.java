class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (pointA, pointB) -> Integer.compare(pointA[1], pointB[1]));
        for(int[] point:points)System.out.println(Arrays.toString(point));
        //if (points.length < 2) return points.length;
        int total = 1;
        int end = points[0][1];
        for(int i = 1; i < points.length; i++) {
            if (points[i][0] > end)
            {
               end = points[i][1];
               total++;
            }
        }
        return total;
    }
}