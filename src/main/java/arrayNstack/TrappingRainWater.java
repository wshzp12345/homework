package arrayNstack;

import java.util.Stack;

public class TrappingRainWater {
    class Solution {
        private Stack<Rect> stack = new Stack<>();
        public int trap(int[] heights) {
            int ans = 0;
            for(int height: heights) {
                int accumulateWidth = 0;
                while(!stack.isEmpty() && stack.peek().height <= height) {
                    int bottom = stack.peek().height;
                    accumulateWidth += stack.peek().width;
                    stack.pop();
                    int top = stack.isEmpty()? bottom: height;
                    if(!stack.isEmpty() && top > stack.peek().height) top = stack.peek().height;
                    ans += accumulateWidth * (top - bottom);
                }
                stack.push(new Rect(height,accumulateWidth +1));
            }
            return ans;
        }
    }

    class Rect {
        int height;
        int width;
        public Rect(int height,int width) {
            this.height = height;
            this.width = width;
        }

    }
}
