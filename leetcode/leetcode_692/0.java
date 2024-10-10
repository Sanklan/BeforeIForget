class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        PriorityQueue<Node> elements = new PriorityQueue<Node>(new Comparator<Node>() {
            public int compare(Node s1, Node s2) {
                if (s1.count == s2.count) return s2.string.compareTo(s1.string);
                return s1.count - s2.count;
            }
        });
        HashMap<String, Integer> map = new HashMap<String, Integer>();

        for(String word:words) map.put(word, map.getOrDefault(word, 0) + 1);
        for(String key:map.keySet()) {
                elements.add(new Node(key, map.get(key)));
                if (elements.size() > k) elements.poll();
        }

       // while(elements.size() > k) elements.poll();



        List<String> ans = new ArrayList<String>();
        // for(Node element:elements) {
        //     ans.add(element.string);
        // }
        // Collections.reverse(ans);

        while(!elements.isEmpty()) ans.add(0, elements.poll().string);
        return ans;

    }

    class Node {
        int count;
        String string;

        public Node(String s, int c) {
            this.string = s;
            this.count = c;
        }
    }
}
