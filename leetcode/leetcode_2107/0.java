class Solution {
    public String findDifferentBinaryString(String[] nums) {
        HashSet<Integer> numbers = new HashSet<Integer>();
        for(String num:nums) {
            numbers.add(Integer.parseInt(num, 2));
        }

        int pow = nums.length;
        int max = (int)Math.pow(2, pow);
        Random random = new Random();
        StringBuilder s = null;
        while(true) {
            int randInt = random.nextInt(max);
            if (!numbers.contains(randInt)){
                s = new StringBuilder(Integer.toBinaryString(randInt));
                while(s != null && s.length() < pow) {
                    s.insert(0, "0");
                }

                return s.toString();
        }}
        //return "";
    }
}