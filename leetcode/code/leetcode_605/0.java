class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (n == 0) return true;
        if (n >= flowerbed.length/2 + 2) return false;
        if (flowerbed.length == 1 && n == 1 && flowerbed[0] == 0) return true;
        if (flowerbed.length == 2 && n == 1 && flowerbed[0] == 0 && flowerbed[1] == 0)
            return true;
        if (flowerbed.length == 2 && n == 1 && (flowerbed[0] == 1 || flowerbed[1] == 1))
            return false;
        int max = 0;
        int i = 0, j = 0;
        while(j < flowerbed.length) {
            if (flowerbed[i] == 1) {
                i++;
                j++;
            } else {
                while(j < flowerbed.length && flowerbed[j] == 0) {
                    j++;
                }
                //max += (i > 0 && j < flowerbed.length) ? ((j - i - 1) / 2) : ((j - i) / 2);
                if ( i == 0 && j == flowerbed.length) {
                    max += (j - i + 1)/ 2;
                } else if (i == 0 && j < flowerbed.length) {
                    max += (j - i) / 2;
                } else if (i > 0 && j == flowerbed.length) {
                    max += (j - i) / 2;
                } else {
                    max += (j - i - 1) / 2;
                }
                i = j;
            }
        }

        return n <= max;
    }
}