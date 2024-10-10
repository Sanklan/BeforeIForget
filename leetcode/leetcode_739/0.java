class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<TempDay> stack = new Stack<TempDay>();

        int[] ans = new int[temperatures.length];

        for(int i = 0; i < temperatures.length; i++) {
            while(!stack.isEmpty() && stack.peek().temp < temperatures[i]) {
                ans[stack.peek().day] = i - stack.peek().day;
                stack.pop();
            }

            stack.add(new TempDay(temperatures[i], i));
        }

        return ans;
    }

    class TempDay {
        int temp;
        int day;

        public TempDay(int temp, int day) {
            this.temp = temp;
            this.day = day;
        }
    }

    // 76 2;73 5;  
    // ans 
    /*
    0 74
    1 75
    2 0
    3 72 
    4 72
    5
    6
    7 
     */
}