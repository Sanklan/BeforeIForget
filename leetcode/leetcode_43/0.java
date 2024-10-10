class Solution {
    public String multiply(String num1, String num2) {
        if (num2.length() == 1 && num2.charAt(0) == '0') return "0";
        if (num1.length() == 1 && num1.charAt(0) == '0') return "0";
        int index = num2.length() - 1;
        LinkedList<String> levels = new LinkedList<String>();
        while(index >= 0) {
            levels.add(multipleSingle(num1, num2.charAt(index)));
            index--;   
        }
        String ans = levels.poll();
        int level = 1;
        while(!levels.isEmpty()) {
            ans = add(ans, levels.poll(), level);
            level++;
        }

        return ans;
    }

    private String add(String previous, String next, int level) {
        StringBuilder ans = new StringBuilder();
        Stack<Integer> added = new Stack<Integer>();
        int index = previous.length() - 1;
        while(level > 0) {
            added.push( Character.getNumericValue(previous.charAt(index)));
            index--;
            level--;
        }

        int carry = 0;
        int nextIndex = next.length() - 1;
        while(nextIndex >= 0) {
            int n = Character.getNumericValue(next.charAt(nextIndex));
            if (index >= 0)
                n += Character.getNumericValue(previous.charAt(index));
            n += carry;
            added.push(n % 10);
            carry = n / 10;

            nextIndex--;
            index--;
        }

        if (carry > 0) added.push(carry);

        StringBuilder ret = new StringBuilder();
        while(!added.isEmpty()) ret.append(added.pop());

        return ret.toString();
    }

    private String multipleSingle(String num1, char c) {
        Stack<Integer> ans = new Stack<Integer>();
        int m = Character.getNumericValue(c);
        int carry = 0;
        int index = num1.length() - 1;
        int n;
        while(index >= 0) {
            n  = Character.getNumericValue(num1.charAt(index)) * m + carry;
            ans.push(n % 10);
            carry = n / 10;
            index--;
        }
        if (carry > 0) ans.push(carry);

        StringBuilder ret = new StringBuilder();
        while(!ans.isEmpty()) ret.append(ans.pop());

        return ret.toString();
    }
}