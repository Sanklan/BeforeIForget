class Solution {

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        HashMap<Integer, List<Integer>> edges = new HashMap<Integer, List<Integer>>();
        int[] indegree = new int[numCourses];
        for(int i = 0; i < numCourses; i++) 
            edges.put(i, new ArrayList<Integer>());

        for(int[] prerequisite: prerequisites) {
            edges.get(prerequisite[1]).add(prerequisite[0]);
            indegree[prerequisite[0]]++;
        }
        
        LinkedList<Integer> queue = new LinkedList<Integer>();
        IntStream.range(0, numCourses)
            .filter( i -> indegree[i] == 0)
            .forEach(queue::add);
        
        int[] ans = new int[numCourses];
        int index = 0;
        while(!queue.isEmpty()) {
           Integer node = queue.poll();
           ans[index++] = node;
           edges.getOrDefault(node, new ArrayList<Integer>())
            .stream()
            .forEach( i -> {
                indegree[i]--; 
                if (indegree[i] == 0) 
                    queue.add(i);
            });
        }

        if (index != numCourses) return new int[0];
        return ans;
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