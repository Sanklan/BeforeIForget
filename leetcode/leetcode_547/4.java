class Solution {
    public int findCircleNum(int[][] isConnected) {
        int[] parent = new int[isConnected.length];
        for(int i = 0; i < isConnected.length; i++)
            parent[i] = i;
        
        boolean[] visited = new boolean[isConnected.length];
        Arrays.fill(visited, false);
        Queue<Integer> q = new LinkedList<Integer>();
        int a;
        for(int node = 0; node < isConnected.length; node++)
            if (!visited[node])
            {
                q.add(node);
                while(!q.isEmpty()) {
                    a = q.poll();
                   // if (!visited[a]) {
                    visited[a] = true;
                    for(int i = 0; i < isConnected.length; i++) {
                    if ( isConnected[a][i] == 1 && !visited[i] ) {
                        q.add(i);
                        parent[i] = parent[a];
                    }
                }
               // }
            }
            }

        return (int)Arrays.stream(parent).distinct().count();
    }
}