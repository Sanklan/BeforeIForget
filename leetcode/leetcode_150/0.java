class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> operands = new Stack<Integer>();
        HashSet<String> operators = new HashSet<String>();
        operators.add("*");
        operators.add("-");
        operators.add("+");
        operators.add("/");

        for(String token:tokens) {
            if (!operators.contains(token)) {
                operands.push(Integer.parseInt(token));
            } else {
                int deno = 0;
                switch (token) {
                    case "*":
                        operands.push(operands.pop() * operands.pop());
                        break;
                    case "/":
                        deno = operands.pop();
                        operands.push(operands.pop() / deno);
                        break;
                    case "-":
                        deno = operands.pop();
                        operands.push(operands.pop() - deno);
                        break;
                    case "+":
                        operands.push(operands.pop() + operands.pop());
                        break;
                }
            }
        }

        return operands.pop();
    }
}