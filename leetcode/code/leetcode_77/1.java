class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        combine(new ArrayList<Integer>(), k, result, 0, n);
        return result;
    }

    private void combine(List<Integer> current, int size, List<List<Integer>> result, int index, int n) {
        if (size == 0) {
            result.add(new ArrayList<Integer>(current));
        } else {
            if (index < n) {
                index++;
                current.add(index);
                combine(current, size - 1, result, index, n);
                current.remove(Integer.valueOf(index));
                combine(current, size, result, index, n);
            }
        }
     }
    }