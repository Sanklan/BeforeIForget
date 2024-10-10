class Solution {
    private HashMap<String, Boolean> memory = new  HashMap<String, Boolean>();
    public boolean wordBreak(String s, List<String> wordDict) {
         HashMap<String, Integer> dict = new HashMap<String, Integer>();
         for(String str:wordDict) {
             dict.put(str, str.length());
         }
        Set<Integer> hSet = new HashSet<Integer>(dict.values());
        List<Integer> lList = new LinkedList<Integer>(); 
        lList.addAll(hSet);
        Collections.sort(lList, Collections.reverseOrder());
        memory.clear();
        return wordBreak(s, dict, lList);
    }
    
    public boolean wordBreak(String s, HashMap<String, Integer> dict, List<Integer> lengths) {
        //System.out.println("called");
        if (s == null || s.isEmpty()) return true;
        if (memory.containsKey(s)) return memory.get(s);
        int length = s.length();
        for(int len: lengths) {
            if (length >= len) {
                if (dict.containsKey(s.substring(length - len))) {
                    boolean result = wordBreak(s.substring(0, length - len), dict, lengths);
                    if (result) {
                        memory.put(s, true);
                        return true;
                    }
                }
            }
        }
       // System.out.println("called");
        memory.put(s, false);
        return false;
    }
}