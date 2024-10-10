class Solution {
    public int maxHeight(int[][] cuboids) {
        for(int[] cube:cuboids) 
            //rotate(cube); 
            Arrays.sort(cube);
        
        Arrays.sort(cuboids, new Comparator<int[]>() {
            public int compare(int[] cube1, int[] cube2) {
                /*if (cube1[0] != cube2[0]) return cube1[0] - cube2[0];
                return cube1[1] - cube2[1];*/
                return (cube1[0]  + cube1[1] + cube1[2] ) - (cube2[0]  + cube2[1] + cube2[2]);
            }
        });

        int[] dp = new int[cuboids.length];
        System.out.println(Arrays.deepToString(cuboids));

        int res = 0;
        for(int i = 0; i < cuboids.length; i++) {
            // height of current box
            dp[i] = cuboids[i][2];
            for(int j = 0; j < i; j++) {
                if (canPlace(cuboids[i], cuboids[j])) {
                    dp[i] = Math.max(dp[i], cuboids[i][2] + dp[j]);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    private boolean canPlace(int[] base, int[] top) {
        return (base[0] >= top[0] && base[1] >= top[1] && base[2] >= top[2])
            || (base[0] <= top[0] && base[1] <= top[1] && base[2] <= top[2]) ;
    }

    private void rotateToSmallest(int[] cube) {
        int smallest = cube[0] > cube[1] ? (cube[1] > cube[2] ? 2 : 1) : (cube[0] > cube[2] ? 2 : 0);
        if (smallest == 0) return;
        if (smallest == 1) {
            int last = cube[0];
            cube[0] = cube[1];
            cube[1] = cube[2];
            cube[2] = last;
        }
        else {
            int first = cube[2];
            cube[2] = cube[1];
            cube[1] = cube[0];
            cube[0] = first;
        }
        
    }

    private void rotate(int[] cube) {
        int smallest = cube[0] > cube[1] ? (cube[0] > cube[2] ? 0 : 2) : (cube[1] > cube[2] ? 1 : 2);
        if (smallest == 2) return;
        if (smallest == 0) {
            int last = cube[0];
            cube[0] = cube[1];
            cube[1] = cube[2];
            cube[2] = last;
        }
        else {
            int first = cube[2];
            cube[2] = cube[1];
            cube[1] = cube[0];
            cube[0] = first;
        }

    }
}