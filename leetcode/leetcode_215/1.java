class Solution {
    public int findKthLargest(int[] nums, int k) {
        int currentMax = Integer.MAX_VALUE;
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
        for(int i = 0; i < k; i++) minHeap.add(nums[i]);

        for(int i = k; i < nums.length; i++) {
            if (nums[i] > minHeap.peek()) {
                minHeap.poll();
                minHeap.offer(nums[i]);
            }
        }

        return minHeap.poll();
    }
}