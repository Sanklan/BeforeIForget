class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> freq = new HashMap<Integer, Integer>();
        for(int num:nums) freq.put(num, freq.getOrDefault(num, 0) + 1);
        
        PriorityQueue<Freq> minHeap = new PriorityQueue<Freq>(new Comparator<Freq>() {
            public int compare(Freq f1, Freq f2) {
                return f1.freq - f2.freq;
            }
        });

        List<Integer> keys = new ArrayList<Integer>(freq.keySet());
        int i = 0, key;
        int len = keys.size();
        while(k > 0 && !freq.isEmpty() && i < len) {
            key = keys.get(i);
            minHeap.add(new Freq(key, freq.get(key)));
            i++;
            k--;
        }

        for(; i < len; i++) {
            key = keys.get(i);
            if (minHeap.peek().freq < freq.get(key)) {
                minHeap.poll();
                minHeap.add(new Freq(key, freq.get(key)));
            }
        }

        //minHeap.forEach(System.out::println);

        int[] ans = new int[minHeap.size()];
        i = minHeap.size() - 1;
        while(!minHeap.isEmpty()) {
            ans[i] = minHeap.poll().data;
            i--;
        }

        return ans;
    }

    class Freq {
        int data;
        int freq;
        public Freq(int d, int f) {
            data = d;
            freq = f;
        }

        public String toString() {
            return freq  + " : " +  data;
        }
    }
}