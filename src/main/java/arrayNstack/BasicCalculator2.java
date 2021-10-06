package arrayNstack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BasicCalculator2 {
    class Solution {
        private Stack<String> ops = new Stack<>();
        private List<String> rpn = new ArrayList<>();
        private Stack<Integer> stack = new Stack<>();

        public int calculate(String string) {
            char ss [] = string.toCharArray();
            String number = "";
            for(char c: ss) {
                if(c==' ') continue;
                if(c>='0' && c<= '9') {
                    number+=String.valueOf(c);
                    continue;
                } else {
                    if(!number.isEmpty()) {
                        rpn.add(number);
                        number="";
                    }
                }
                int rank = getRank(String.valueOf(c));
                // 3 2 2 * +
                // 3 * 2 +2
                // 3 2 * 2 +
                while(!ops.isEmpty() && getRank(ops.peek()) >= rank ) {
                    rpn.add(ops.pop());
                }
                ops.push(String.valueOf(c));
            }
            if(!number.isEmpty()) {
                rpn.add(number);
                number="";
            }
            while(!ops.isEmpty()) {
                rpn.add(ops.pop());
            }
            return evalRPN(rpn.toArray(new String[rpn.size()]));
        }

        public int getRank(String c) {
            if(c.equals("+") || c.equals("-")) return 1;
            if(c.equals("/")||c.equals("*")) return 2;
            return 0;
        }

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
