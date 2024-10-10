class Solution {
    public List<List<String>> findDuplicate(String[] paths) {
        HashMap<String, List<String>> map = new HashMap<String, List<String>>();
        String[] split, data;
        for(String path:paths) {
            split = path.split(" ");
            for( int i = 1; i < split.length; i++) {
                data = fileprocessor(split[i]);
                if (!map.containsKey(data[1])) map.put(data[1], new ArrayList<String>());
                map.get(data[1]).add(split[0] + "/" + data[0]);
            }
        }

        List<List<String>> ret = new ArrayList<List<String>>();

        for(String key:map.keySet()) {
            if (map.get(key).size() > 1) ret.add(map.get(key));
        }

        return ret;
    }

    private String[] fileprocessor(String path) {
        path = path.trim();
        int i = 0;
        while( i < path.length() && path.charAt(i) != '(') i++;
        String[] data = new String[2];
        data[0] = path.substring(0, i);
        data[1] = path.substring(i + 1, path.length() - 1);
        return data;
    }
}