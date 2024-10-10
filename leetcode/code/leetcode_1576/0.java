class Solution {
    public int minReorder(int n, int[][] connections) {
        boolean[] visited = new boolean[connections.length + 1];
        ArrayList<ArrayList<Integer>> neigh = new ArrayList<ArrayList<Integer>>();
        for(int i = 0;  i <= connections.length ; i++)
            neigh.add(new ArrayList<Integer>());
        for(int[] connection:connections) {
            neigh.get(connection[0]).add(connection[1]);
            neigh.get(connection[1]).add(-1 * connection[0]);
        }
        int count = 0, index;
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(0);
        while(!q.isEmpty()) {
                visited[q.peek()] = true;
                int current = q.poll();
                for(int i:neigh.get(current)) {
                    index = Math.abs(i);
                   if(!visited[index]) { 
                    if (i >= 0) {
                        count++;
                    }
                    q.add(index);
                    }
                }
        }

        return count;
    }
}