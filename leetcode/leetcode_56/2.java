class Solution {
    public int[][] merge(int[][] intervals) {
        PriorityQueue<Interval> queue = new PriorityQueue<Interval>();
        for(int[] interval:intervals) 
            queue.offer(new Interval(interval[0], interval[1]));
        
        ArrayList<Interval> merged = new ArrayList<Interval>();
        Interval current = null;
        while(!queue.isEmpty()) {
            Interval next = queue.poll();
            if (merged.isEmpty() || current.end < next.start) {
                current = next;
                merged.add(next);
            } else {
                if (current.end < next.end) 
                    current.end = next.end;
            }
        }

        int size = merged.size();
        int[][] result = new int[size][2];

        for(int i = 0; i < size; i++) 
            result[i] = merged.get(i).toArray();

        return result;

    }



}

class Interval implements Comparable<Interval> {
    int start;
    int end;

    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public int compareTo(Interval that) {
        int comp = ((Integer)this.start).compareTo(that.start);
        if (comp == 0) {
            return ((Integer)this.end).compareTo(that.end);
        }

        return comp;
    }

    public int[] toArray() {
        return new int[] {start, end};
    }
}