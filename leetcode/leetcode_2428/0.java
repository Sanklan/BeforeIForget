class Solution {
    public int equalPairs(int[][] grid) {
       HashMap<String, Integer> rows = new HashMap<String, Integer>();
       for(int i = 0; i < grid.length; i++) {
        StringBuilder string = new StringBuilder();
            for(int j = 0; j < grid.length; j++) {
                string.append(grid[i][j] + "_");
            }

            rows.put(string.toString(), rows.getOrDefault(string.toString(), 0) + 1);
       }
        int count = 0;
       for(int i = 0; i < grid.length; i++) {
        StringBuilder string = new StringBuilder();
            for(int j = 0; j < grid.length; j++) {
                string.append(grid[j][i] + "_");
            }

            if (rows.containsKey(string.toString())) count+=rows.get(string.toString());
       }

        return count;
    }


}