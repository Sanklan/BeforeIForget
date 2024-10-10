class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> res = new ArrayList<Integer>();
        res.add(1);
        int current = 0;
        while(current < rowIndex) {
            res = next(res);
            current++;

        }

        return res;
    }

    List<Integer> next(List<Integer> input) {
        List<Integer> res = new ArrayList<Integer>();
        res.add(1);
        int n = input.size();
        for(int i = 1; i < n; i++)
            res.add(input.get(i - 1) + input.get(i));
        res.add(1);
        return res;
    }
}