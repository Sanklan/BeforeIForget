class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
     final HashMap<String, List<String>> data = new HashMap<String, List<String>>();
     Arrays.stream(strs).forEach(
        (str) -> {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            if (!data.containsKey(key)) data.put(key, new ArrayList<String>());
            data.get(key).add(str);            
        } 
     );
        
    return data.values().stream().collect(Collectors.toList());
    }
}