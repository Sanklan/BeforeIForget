class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
        Queue<int[]> q = new LinkedList<int[]>();
        q.add(entrance);
        HashSet<String> visited = new HashSet<String>();
        int steps = 0;
        int m = maze.length;
        int n = maze[0].length;
        int[] current;
        int size = 0;
        while(!q.isEmpty()) {
            size = q.size();
            while(size > 0){
                current = q.poll();
               if (!visited.contains(key(current))) {
                    visited.add(key(current));
                    if (!(current[0] == entrance[0] && current[1] == entrance[1]) 
                        && isBorder(current[0], current[1], m, n)) 
                            return steps;

                    if (isValid(current[0] + 1, current[1], m, n) && isDot(maze,current[0] + 1, current[1])) {
                        q.add(new int[]{current[0] + 1, current[1]});
                    }
                    if (isValid(current[0] - 1, current[1], m, n) && isDot(maze,current[0] - 1, current[1])) {
                        q.add(new int[]{current[0] - 1, current[1]});
                    }
                    if (isValid(current[0], current[1] + 1, m, n) && isDot(maze,current[0], current[1] + 1)) {
                        q.add(new int[]{current[0], current[1] + 1});
                    }
                    if (isValid(current[0], current[1] - 1, m, n) && isDot(maze,current[0], current[1] - 1)) {
                        q.add(new int[]{current[0], current[1] - 1});
                    }

                }
                size--;
            }

            steps++;
        }

        return -1;
    }

    boolean isValid(int x, int y, int m, int n) {
        return x >= 0 && y >= 0 && x < m && y < n;
    }

    String key(int[] y) {
        return y[0] + "_" + y[1];
    }

    boolean isBorder(int x, int y, int m, int n) {
        return x == 0 || y == 0 || x == m - 1 || y == n - 1;
    }

    boolean isDot(char[][] maze, int x, int y) {
        return maze[x][y] == '.';
    }
}