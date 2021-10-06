package arrayNstack;

import java.util.Stack;

public class EvaluateReversePolishNotation {
    class Solution {
        Stack<Integer> stack = new Stack<>();
        public int evalRPN(String[] tokens) {
            for(String cur : tokens) {
                if(cur.equals("+") ||cur.equals("-") ||cur.equals("*") ||cur.equals("/") ) {
                    int val1 = stack.pop();
                    int val2 = stack.pop();
                    int result = cal(val1, val2,cur);
                    stack.push(result);
                } else {
                    stack.push(Integer.parseInt(cur));
                }
            }
            return stack.pop();
        }

        private int cal(int v1, int v2, String opertor) {
            if(opertor.equals("+")) return v1 + v2;
            if(opertor.equals("-")) return v2 - v1;
            if(opertor.equals("*")) return v1 * v2;
            if(opertor.equals("/")) return v2 / v1;
            return 0;
        }
    }
}
