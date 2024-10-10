class Solution {
    public int numberOfBoomerangs(int[][] points) {
        int count = 0;
        for(int i = 0; i < points.length; i++) {
            int[] current = points[i];
                       
            for (int j = i + 1; j < points.length; j++) {
                int[] second = points[j];
                int d = distance(current, second);
                
                if (!data.containsKey(i)) 
                    data.put(i, new HashMap<Integer, List<Integer>>());
                if (!data.containsKey(j)) 
                    data.put(j, new HashMap<Integer, List<Integer>>());
                
                HashMap<Integer, List<Integer>> ihash = data.get(i);
                HashMap<Integer, List<Integer>> jhash = data.get(j);
                
                if (!ihash.containsKey(d)) ihash.put( d, new ArrayList<Integer>());
                if (!jhash.containsKey(d)) jhash.put( d, new ArrayList<Integer>());
                
                ihash.get(d).add(j);
                jhash.get(d).add(i);                
            }
        }
        
        int result = 0;
        for( HashMap<Integer, List<Integer>> d: data.values()) 
        {
            for(List<Integer> l: d.values()) {
                int n = l.size();
                if (n >= 2) {
                    result += (n*(n-1));
                }
            }
        }
        
        return result;
    }
    
    private int distance(int[] a, int[] b) {
        return (int)(Math.pow( a[0] - b[0] , 2) + Math.pow( a[1] - b[1] , 2));
    }
    
    private HashMap<Integer, HashMap<Integer, List<Integer>>> data = 
        new HashMap<Integer, HashMap<Integer, List<Integer>>>();
}