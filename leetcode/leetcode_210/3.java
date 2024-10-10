class Solution {

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        HashMap<Integer, List<Integer>> edges = new HashMap<Integer, List<Integer>>();
        for(int i = 0; i < numCourses; i++) 
            edges.put(i, new ArrayList<Integer>());

        for(int[] prerequisite: prerequisites) 
            edges.get(prerequisite[1]).add(prerequisite[0]);
        
        int[] indegree = new int[numCourses];
        Arrays.fill(indegree, 0);
        edges.values().stream()
            .forEach( list -> list.stream().forEach( i -> indegree[i]++));
        LinkedList<Integer> queue = new LinkedList<Integer>();
        queueIndependent(indegree, queue, edges);
        int[] ans = new int[numCourses];
        Arrays.fill(ans, -1);
        int index = 0;
        while(!queue.isEmpty()) {
            while(!queue.isEmpty()) {
                Integer node = queue.poll();
                edges.getOrDefault(node, new ArrayList()).stream().forEach( i -> indegree[(int)i]--);
                ans[index++] = node;
                edges.remove(node);
            }

            queueIndependent(indegree, queue, edges);
        }

        if (index != numCourses) return new int[0];
        return ans;
    }

    private void queueIndependent(int[] indegree, LinkedList<Integer> queue, HashMap<Integer, List<Integer>> graph) {
        for(int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0 && graph.containsKey(i)) {
                queue.add(i);
            }
        }
    }
    


    public int[] findOrder1(int numCourses, int[][] prerequisites) {
        boolean[] visited = new boolean[numCourses];
        Arrays.fill(visited, false);
        List<List<Integer>> prereqs = new ArrayList<List<Integer>>();
        IntStream.range(0, numCourses).forEach(i -> prereqs.add(new ArrayList<Integer>()));

        for(int[] pr:prerequisites) 
            prereqs.get(pr[0]).add(pr[1]);
        final Stack<Integer> ans = new Stack<Integer>();
        
        IntStream.range(0, numCourses)
            .forEach( i -> topologicalSortUtil(i, visited, ans, prereqs));

        final int[] ret = new int[numCourses];
        IntStream.range(0, numCourses)
            .forEach( i -> ret[numCourses - i - 1] = ans.pop());
        return ret;
    }

    private void topologicalSortUtil(int n, boolean[] visited, Stack<Integer> ans, List<List<Integer>> prereq) {
        if (visited[n]) return;
        visited[n] = true;
        for(int prerequisited:prereq.get(n)) {
            //if (visited[prerequisited]) throw new CycleDetectedException();
            topologicalSortUtil(prerequisited, visited, ans, prereq);
        }

        ans.push(n);
    }

    


}


class CycleDetectedException extends Exception {

}