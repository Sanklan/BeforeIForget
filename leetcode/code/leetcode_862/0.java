class Solution {
    public String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i < indices.length; i++) {
            map.put(indices[i], i);
        }

        Arrays.sort(indices);

        StringBuilder str = new StringBuilder(s);
        for(int i = indices.length - 1; i >= 0; i--) {
            int index = map.get(indices[i]);            
            if (str.substring(indices[i], indices[i] + sources[index].length()).equals(sources[index])) {
                str.replace(indices[i], indices[i] + sources[index].length(), targets[index]);
            }
        }
         return str.toString();
    }
}