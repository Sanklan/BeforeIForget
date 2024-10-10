class Solution {
    public int largestRectangleArea(int[] heights) {
        int left[] = new int[heights.length];
        int right[] = new int[heights.length];
        
        Stack<Integer> stack = new Stack<Integer>();
        for(int i = 0; i < heights.length; i++) {
            while(!stack.isEmpty() && heights[stack.peek()] >= heights[i]) stack.pop();
            left[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }
        stack.clear();
        for(int i = heights.length - 1; i >= 0; i--) {
            while(!stack.isEmpty() && heights[stack.peek()] >= heights[i]) stack.pop();
            right[i] = stack.isEmpty() ? heights.length : stack.peek();
            stack.push(i);
        }
        
        
        int max = 0;
        for(int i = 0; i < heights.length; i++) {
            int width = right[i] - left[i] - 1;
            max = Math.max(max, heights[i] * width);
        }
        
        return max;
    }
        /*
        int left = 0;
        int right = 0;
        while(right < heights.length) {
            while(right < heights.length && heights[right] > 0) right++;
            max = getMax(left, right - 1, heights);
            left = right;
        }
        
        return max;
    }
    
    private int getMax(int left, int right, int[] heights) {
        PriorityQueue<Integer> minHeap = new PriorityQueue();
        for(int i = left; i <= right; i++) minHeap.add(heights[i]);
        int max = 0;
        while(left <= right) {
          max = Math.max(max, minHeap.peek() * (right - left + 1));
          if (heights[left] < heights[right]) {
              minHeap.remove(heights[left]);
              left++;
          } else {
              //left > = right
              minHeap.remove(heights[right]);
              right--;
          }
      }
        
      return max;
    }*/
}