class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        HashMap<Integer, List<Integer>> egdesMap = new HashMap<Integer, List<Integer>>();
        HashSet<Integer> visited = new HashSet<Integer>();
        for(int[] edge:edges) {
            if (!egdesMap.containsKey(edge[0]))
                egdesMap.put(edge[0],  new ArrayList<Integer>());
            
            if (!egdesMap.containsKey(edge[1]))
                egdesMap.put(edge[1],  new ArrayList<Integer>());
            egdesMap.get(edge[0]).add(edge[1]);
            egdesMap.get(edge[1]).add(edge[0]);
        }

        return isValidPath(egdesMap, visited, source, destination);
    }

    private boolean isValidPath(HashMap<Integer, List<Integer>> egdesMap, HashSet<Integer> visited, int src, int dest) {
        if (src == dest) return true;
        if (visited.contains(src)) return false;
        visited.add(src);
        for(int newSrc:egdesMap.get(src))
        {
            if (isValidPath(egdesMap, visited, newSrc, dest)) return true;
        }
        return false;
    }
}