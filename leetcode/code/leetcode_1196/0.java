class Solution {
    public int minHeightShelves(int[][] books, int shelfWidth) {
        memory = new HashMap<Integer, Integer>();
        return minHeight(0, books, shelfWidth);
    }
    
    private int minHeight(int startIndex, int[][] books, int shelfWidth) {
        if (startIndex >= books.length) return 0;
        int key = startIndex;
        
        if (memory.containsKey(key)) return memory.get(key);
    
        int currentWidth = 0;
        int currentHeight = 0;
        
        int totalHeight = Integer.MAX_VALUE;
        while(startIndex < books.length) {
            currentWidth += books[startIndex][0];
            if (currentWidth > shelfWidth) break;
            
            currentHeight = Math.max(currentHeight, books[startIndex][1]);
            startIndex++;
            int height = currentHeight + minHeight(startIndex, books, shelfWidth);
            
            totalHeight = Math.min(totalHeight, height);
            
        }
        memory.put(key, totalHeight);
        return totalHeight;
    }
    
    private static HashMap<Integer, Integer> memory;
}