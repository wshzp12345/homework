package arrayNstack;

import java.util.Stack;

public class LargestRectangleInHistogram {
    class Solution {
        private Stack<Rect> stack = new Stack<>();
        public int largestRectangleArea(int[] heights) {
            int ans = 0;


            for(int height : heights) {
                int accumulateWidth = 0;
                while(!stack.isEmpty() && stack.peek().height >= height) {
                    accumulateWidth += stack.peek().width;
                    ans = Math.max(ans,stack.peek().height * accumulateWidth);
                    stack.pop();
                }
                stack.push(new Rect(height,accumulateWidth+1));
            }
            int accumulateWidth = 0;
            while(!stack.isEmpty() ) {
                accumulateWidth += stack.peek().width;
                ans = Math.max(ans,stack.peek().height * accumulateWidth);
                stack.pop();
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
    class Solution2 {
        private Stack<Integer> stack = new Stack<>();
        public int largestRectangleArea(int[] heights) {
            int ans = 0;

            int[] tmp = new int[heights.length + 2];
            System.arraycopy(heights, 0, tmp, 1, heights.length);
            for(int i = 0; i < tmp.length; i++) {
                int accumulateWidth = 1;
                while(!stack.isEmpty() && tmp[stack.peek()] > tmp[i]) {
                    int h =  tmp[stack.pop()];
                    ans = Math.max(ans, (i - stack.peek()-1)* h);
                }
                stack.push(i);
            }
            return ans;
        }
    }

}
