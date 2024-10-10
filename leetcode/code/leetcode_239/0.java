class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        /**
        Bucket of k size with max O(n) or O(1) if sorted
        search and delete a particular element 
            O(1) hash table and 
            O(logn) binary search
            O(n) linear search

        Max Heap -> max constant but deleting & adding -> nlogk + searching heap O(nk)  
        
        maintain sorted array for size k 
            - search o(logn)
            - delete constant time but entry can O(k) => n * k

        Doubly linked list - maintain the sorted
        - max constant time
        - delete constant time
        - search O(n)
            - buy maintain a hashtable with node's location to delete
        - insertion would still be O(k) -> n * k

        arraylist
            binarysearch & insertion in logk
            binarysearch & delete in logk
            max O(1)

        Hashset/hashmap
            -> insertion is constant
            -> deletion is constant but frequency
            -> max

        TreeMap
            -> insertion is constant
            -> deletion is constant but frequency
            -> max        
         */

         TreeMap<Integer, Integer> kElements = new TreeMap<Integer, Integer>();
         int[] max = new int[nums.length - k + 1];

         for(int i = 0; i < k; i++) {
             kElements.put(nums[i], kElements.getOrDefault(nums[i], 0) + 1);
         }
         
         int index = 0;
         max[index++] = kElements.lastKey();
         for (int i = k; i < nums.length; i++) {

             kElements.put(nums[i], kElements.getOrDefault(nums[i], 0) + 1);

             kElements.put(nums[i -k],  kElements.getOrDefault(nums[i -k], 0) - 1);
             if (kElements.get(nums[i-k]) <= 0) kElements.remove(nums[i-k]);

             max[index++] = kElements.lastKey();
         }

         return max;
    }
}