class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        HashMap<Integer, List<Integer>> deps = new HashMap<Integer, List<Integer>>();

        for(int[] preq:prerequisites) {
            if (!deps.containsKey(preq[1])) deps.put(preq[1], new ArrayList<Integer>());
            deps.get(preq[1]).add(preq[0]);
            indegree[preq[0]]++;
        }

        Queue<Integer> q = new LinkedList<Integer>();
        for(int i = 0; i < numCourses; i++) 
            if (indegree[i] == 0) q.add(i);

        List<Integer> ans = new ArrayList<Integer>();
        while(!q.isEmpty()) {
            ans.add(q.peek());
            for(int fol:deps.getOrDefault(q.poll(), new ArrayList<Integer>())) {
                indegree[fol]--;
                if (indegree[fol] == 0) q.add(fol);
            }
        }

        if (ans.size() < numCourses) return new int[0];        
        int[] ret = new int[numCourses];
        int index =0;
        for(int a:ans) ret[index++] = a;
        return ret;
    }
}