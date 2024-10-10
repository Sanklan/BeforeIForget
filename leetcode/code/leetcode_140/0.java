class Solution {
    HashMap<String, List<String>> memo = new  HashMap<String, List<String>>();
    public List<String> wordBreak(String s, List<String> wordDict) {
   HashMap<String, Integer> dict = new HashMap<String, Integer>();
         for(String str:wordDict) {
             dict.put(str, str.length());
         }
        Set<Integer> hSet = new HashSet<Integer>(dict.values());
        List<Integer> lList = new LinkedList<Integer>(); 
        lList.addAll(hSet);
        Collections.sort(lList, Collections.reverseOrder());
        memo.clear();
        return wordBreak(s, dict, lList);
    }
    
    public List<String> wordBreak(String s, HashMap<String, Integer> dict, List<Integer> lengths) {
        //if (s == null || s.isEmpty()) return new ArrayList<String>();
        int length = s.length();
        if (memo.containsKey(s)) return memo.get(s);
        
        List<String> res = new ArrayList<String>();
        for(int len: lengths) {
            if (length >= len) {
                if (dict.containsKey(s.substring(0, len))) {
                    if (len == length) {
                        res.add(s);
                    } else {
                        List<String> result = wordBreak(s.substring(len), dict, lengths);
                        for(String k: result) {
                            res.add(s.substring(0, len) + " " + k);
                        }   
                    }
                }
            }
        }
        memo.put(s, res);
        return res;
    }
}