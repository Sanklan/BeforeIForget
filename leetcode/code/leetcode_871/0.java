class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] visited = new boolean[rooms.size()];
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(0);
        int key;
        while(!queue.isEmpty()) {
            key = queue.poll();
            if (!visited[key]) {
                visited[key] = true;
                for(int k:rooms.get(key)) 
                    if (!visited[k]) queue.add(k);
            }
        }

        boolean ans = true;
        for(boolean room:visited) ans &= room;
        return ans;
    }
}