class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        int[] tempRow = {1};
        result.add(Arrays.stream(tempRow).boxed().collect(Collectors.toList()));
        if (numRows == 1) return result;
        int[] tempRow1 = { 1, 1 };
        result.add(Arrays.stream(tempRow1).boxed().collect(Collectors.toList()));
        if (numRows == 2) return result;
        
        int i = 3; 
        while(i <= numRows) {
            List<Integer> row = new ArrayList<Integer>();
            List<Integer> previous = result.get(i - 2);
            for(int j = 1; j <= i; j++ ) {
              int xIndex = j - 1;
              int yIndex = j;
              if (xIndex < 1 || yIndex >= i ) row.add(1);
              else row.add(previous.get(xIndex - 1) + previous.get(yIndex -1));
            }
            result.add(row);
            i++;
        }
        
        return result;
    }
}