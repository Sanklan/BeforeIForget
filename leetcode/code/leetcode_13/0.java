class Solution {
    public int romanToInt(String s) {
        build();
        int sum = 0;
        int index = 0;
        int n = s.length();
        while(index < n) {
            if (index + 1 < n) {
                String key = s.charAt(index) + "" + s.charAt(index + 1);
                if (map.containsKey(key)) {
                    sum += map.get(key);
                    index += 2;
                    continue;
                }
            }
            String key = s.charAt(index) + "";
            //System.out.println(key);
            sum += map.get(key);
            index += 1;
        }
        
        return sum;
    }
    
    HashMap<String, Integer> map = new HashMap<String, Integer>();
    
    private void build() {
        if (map.size() > 0) return;
        map.put("I",1   );
        map.put("V",5   );
        map.put("X",10  );
        map.put("L",50  );
        map.put("C",100 );
        map.put("D",500 );
        map.put("M",1000);
        
        map.put("IV", 4);
        map.put("IX", 9);
        map.put("XL", 40);
        map.put("XC", 90);
        map.put("CD", 400);
        map.put("CM", 900);
    }
}