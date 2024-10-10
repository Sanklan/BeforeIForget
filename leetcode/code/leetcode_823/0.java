class Solution {
    public boolean splitArraySameAverage(int[] nums) {
        if (nums.length < 2) return false;
        int size = nums.length / 2;

        int sum = 0;
        for(int num: nums) sum += num;
        boolean check = false;
        for(int i = 1; i <= nums.length/2; i++) {
            if ((sum * i) % nums.length == 0) {
                check = true;
                break;
            }
        }

        if (!check) return false;
       // System.out.println("check passed");

        List<HashSet<Integer>> result = new ArrayList<HashSet<Integer>>();
        for(int i = 0; i <= size; i++) result.add(new HashSet<Integer>());

        result.get(0).add(0);
       // Arrays.sort(nums);
        for(int num:nums) {
            for(int i = size - 1; i >= 0; i--) {
                HashSet<Integer> previous = result.get(i);
                for(int subSum: previous) result.get( i + 1 ).add(num + subSum);
            }
        }
        
        for( int i = 1; i <= size; i++) {
            if (sum * i % nums.length == 0 && result.get(i).contains(sum * i / nums.length)) return true;
        }

        return false;
    }
}