class Solution {
    public int numTrees(int n) {
        int[] bst = new int[n + 1];
        bst[0] = 1;
        bst[1] = 1;
        for(int currentN = 2; currentN <= n; currentN++) {
            for(int i = 1; i  <= currentN; i++) {
                bst[currentN] += (bst[ i - 1] * bst[currentN - i]);
            }
        }

        return bst[n];
    }
}