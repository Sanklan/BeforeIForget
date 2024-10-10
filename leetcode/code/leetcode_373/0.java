class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        
        PriorityQueue<Pair> maxHeap = new PriorityQueue<Pair>(new Comparator<Pair>() {
            public int compare(Pair p1, Pair p2) {
                return p2.sum - p1.sum;
            }
        });

        int i = 0, j = 0;
        // adding k pairs;
        for(; i < nums1.length && k > 0; i++) {
            j = 0;
            for(; j < nums2.length && k > 0; j++) {
               // System.out.println("Adding " +  nums1[i] +" , " + nums2[j]);
                maxHeap.add(new Pair(nums1[i], nums2[j]));
                k--;
            }
            
        }
        i--;
        //j--;
       // System.out.println(i + ", " + j);
        for(; i < nums1.length; i++) {

            for(; j < nums2.length; j++) {
                if (maxHeap.peek().sum > nums1[i] + nums2[j])
                {
                    maxHeap.poll();
                    maxHeap.add(new Pair(nums1[i], nums2[j]));
                  //  System.out.println("..Adding " +  nums1[i] +" , " + nums2[j]);
                } else {
                    break;
                }
            }
            j = 0;
        }


        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        while(!maxHeap.isEmpty()) {
            ret.add(maxHeap.poll().toList());
        }
        Collections.reverse(ret);

        return ret;

    }

    class Pair {
        int x, y, sum;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
            sum = x + y;
        }

        public List<Integer> toList() {
            List<Integer> lst = new ArrayList<Integer>();
            lst.add(x);
            lst.add(y);
            return lst;
        }
     }
}