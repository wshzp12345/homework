package arrayNstack;

import java.util.Stack;

public class MinStack {
    private Stack<Integer> min = new Stack<>();
    private Stack<Integer> valS =  new Stack<>();

    public MinStack() {

    }

    public void push(int val) {
        valS.push(val);
        if(min.isEmpty()) {
            min.push(val);
        }else {
            if(val> min.peek()) {
                min.push(min.peek());
            } else {
                min.push(val);
            }
        }
    }

    public void pop() {
        valS.pop();
        min.pop();
    }

    public int top() {
        return valS.peek();
    }

    public int getMin() {
        return min.peek();
    }
}
